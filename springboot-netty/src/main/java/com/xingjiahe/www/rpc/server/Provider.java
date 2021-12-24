package com.xingjiahe.www.rpc.server;

import com.xingjiahe.www.rpc.service.IUserService;
import com.xingjiahe.www.rpc.service.impl.UserServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                //1.接收所有参数
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                String apiClassName = inputStream.readUTF();
                String methodName = inputStream.readUTF();
                Class[] patamTypes = (Class[]) inputStream.readObject();
                Object[] args4Method = (Object[]) inputStream.readObject();
                Class clazz = null;
                //2.服务注册找到具体的类
                if (apiClassName.equals(IUserService.class.getName())) {
                    clazz = UserServiceImpl.class;
                }
                //3.反射调用 执行方法
                Method method = clazz.getMethod(methodName, patamTypes);
                Object invoke = method.invoke(clazz.newInstance(), args4Method);
                //4.返回结果给客户端
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(invoke);
                outputStream.flush();

                //5.关闭连接
                outputStream.close();
                inputStream.close();
                socket.close();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
