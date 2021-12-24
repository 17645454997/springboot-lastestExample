package com.xingjiahe.www.rpc.client;

import com.xingjiahe.www.rpc.service.IUserService;
import com.xingjiahe.www.rpc.protocol.ProtoDemo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Consumer  {
    public static void main(String[] args) {
        IUserService userService = (IUserService) rpc(IUserService.class);
        ProtoDemo.Student student = userService.findById(123L);
        System.out.println(student);
    }
    public  static  Object rpc(Class clazz){
        return Proxy.newProxyInstance(
                clazz.getClassLoader(),
                 new Class[]{clazz},
                 new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                       //1.建立远程连接
                        Socket socket = new Socket("127.0.0.1",8888);
                        //2.要调用的类，方法，参数
                        String apiName = clazz.getName();
                        String methodName = method.getName();
                        //3.传入参数类型，防止重载
                        Class [] parameterTypes = method.getParameterTypes();
                        //4.传输类信息，请求执行结果
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeUTF(apiName);
                        outputStream.writeUTF(methodName);
                        outputStream.writeObject(parameterTypes);
                        outputStream.writeObject(args);
                        outputStream.flush();
                        //5.接收返回的结果
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        Object object = inputStream.readObject();
                        inputStream.close();
                        outputStream.close();
                        socket.close();
                        return object;
                    }
                });

    }
}
