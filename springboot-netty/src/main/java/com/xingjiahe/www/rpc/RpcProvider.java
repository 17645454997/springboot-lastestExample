package com.xingjiahe.www.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcProvider {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
               String apiClassName = inputStream.readUTF();
               String methodName = inputStream.readUTF();
               Class [] paramTypes= (Class[]) inputStream.readObject();
               Object[] args4Method = (Object[])inputStream.readObject();
               Class clazz = null;
               if(apiClassName.equals(clazz.getName())){
                   clazz = UserServiceImpl.class;
               }
                Method method = clazz.getMethod(methodName,paramTypes);
                Object invoke = method.invoke(clazz.newInstance(), args4Method);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                 outputStream.writeObject(invoke);
                 outputStream.flush();
                 inputStream.close();
                 outputStream.close();
                 socket.close();
            }

        }catch(Exception e){
          e.printStackTrace();
        }
    }


}
