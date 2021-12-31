package com.xingjiahe.www.protobuf.client;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/24 下午1:48
 */

import com.google.protobuf.util.JsonFormat;
import com.xingjiahe.www.protobuf.request.LoginRequest;
import com.xingjiahe.www.protobuf.response.LoginResponse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws Exception {
        //前端socket链接
        Socket socket = new Socket("localhost", 19000);
        // 读取服务器端传过来信息的DataInputStream
        DataInputStream in = new DataInputStream(socket.getInputStream());
        // 向服务器端发送信息的DataOutputStream
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        //构造一个LoginReq对象
        LoginRequest.LoginReq loginReq = LoginRequest.LoginReq.newBuilder()
                .setType(1)
                .setName("soda")
                .setPass("123456")
                .build();
        //转成字节，计算发送的pb协议大小
        byte[] bodyBytes = loginReq.toByteArray();

        //定义消息体头(消息体内容+上版本号的大小)
        out.writeShort(bodyBytes.length + 4);
        //写版本号
        out.writeShort(1);
        //消息指令,消息指令是唯一的，返回指令比发送指令多10000,也就是20001
        out.writeShort(10001);
        //写消息体
        out.write(bodyBytes);
        out.flush();

        //这里接受服务器数据.解析服务器的发送协议流程，基本上客户端发送给服务端类似
        //先收消息长度大小
        short msgLength = in.readShort();
        //消息指令
        short cmd = in.readShort();
        //剩下的字节都是消息体
        byte[] bytes = new byte[msgLength - 2];
        in.read(bytes);
        //这里规定服务器返回是多1w的协议号。实际项目这里应该做好架构，动态处理
        if(cmd == 20001)
        {
            LoginResponse.LoginRep loginRep = LoginResponse.LoginRep.parseFrom(bytes);
            System.out.println("服务器返回数据:" + JsonFormat.printer().print(loginRep));
        }
        //闭流
        out.close();
        System.out.println("client close");
    }
}

