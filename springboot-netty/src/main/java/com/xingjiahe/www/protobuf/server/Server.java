package com.xingjiahe.www.protobuf.server;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2021/12/24 下午1:49
 */

import com.xingjiahe.www.protobuf.request.LoginRequest;
import com.xingjiahe.www.protobuf.response.LoginResponse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        //建立Socket服务器
        ServerSocket serverSocket = new ServerSocket(19000);
        System.out.println("服务器socket启动.");
        while (true)
        {
            //监听客户端的连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("有一个客户端连接上来");
            // 读取客户端传过来信息的DataInputStream
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            // 向客户端发送信息的DataOutputStream
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            //先收消息长度大小
            short msgLength = in.readShort();
            //定义消息的版本，目前用不上
            short version = in.readShort();
            //消息指令，这个指令很重要，用来识别后面的消息体是什么东西来的
            short cmd = in.readShort();
            //剩下的字节都是消息体(减去已经度的4个字节)
            byte[] bytes = new byte[msgLength - 4];
            //直接读
            in.read(bytes);
            //这里直接判断cmd的值，实际做项目的话，这里的代码会进行底层封装，应该是自动解析，而不是手动判断
            if(cmd == 10001)
            {
                //转换成登录请求对象
                LoginRequest.LoginReq loginReq = LoginRequest.LoginReq.parseFrom(bytes);
                System.out.printf("loginReq:" + loginReq);
                //
                LoginResponse.LoginRep.Builder builder = LoginResponse.LoginRep.newBuilder();
                if(loginReq.getName().equals("soda"))
                {
                    builder.setResult(1);
                    builder.setMsg("登录成功");
                }
                else
                {
                    builder.setResult(0);
                    builder.setMsg("登录失败");
                }
                //创建登录返回对象
                LoginResponse.LoginRep loginRep = builder.build();
                //封装消息体发送给前端
                //计算发送的pb协议大小
                byte[] bodyBytes = loginRep.toByteArray();

                //定义消息体头(消息体内容+cmd的大小)，服务器不需要返回版本号
                out.writeShort(bodyBytes.length + 2);
                //消息指令,服务器返回20001
                out.writeShort(20001);
                //写消息体
                out.write(bodyBytes);
                out.flush();
            }
        }
    }
}
