package com.xingjiahe.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockIO {

    public static void main(String[] args)throws  Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        String request ,response;
        while ((request = in.readLine())!=null){
            if("Done".equals(request)){
                break;
            }
            response=processRequest(request);
            out.println(response);
        }
    }

    private static String processRequest(String request) {

        return  "BlockIOTestSUCESS";
    }
}
