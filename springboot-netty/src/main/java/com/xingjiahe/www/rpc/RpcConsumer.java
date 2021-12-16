package com.xingjiahe.www.rpc;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class RpcConsumer {

    public static void main(String[] args) {
        IUserService userService = (IUserService) rpc(IUserService.class);
        User user = userService.findById(123L);
        System.out.println(user);
    }


     public  static  Object rpc (Class clazz){
        return Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket("127.0.0.1",8888);
                        String clazzName = clazz.getName();
                        String methodName = method.getName();
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeUTF(clazzName);
                        outputStream.writeUTF(methodName);
                        outputStream.writeObject(parameterTypes);
                        outputStream.writeObject(args);
                        outputStream.flush();
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        Object object = inputStream.readObject();
                        inputStream.close();
                        outputStream.close();
                        socket.close();
                        return object;
                    }
                }
        );
     }


}
