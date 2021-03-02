package com.xingjiahe.www.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EcoClient {
    private  final String host;
    private  final int  port;

    public EcoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b  = new Bootstrap();
            b.group(group)
              .channel(NioSocketChannel.class)
              .remoteAddress(new InetSocketAddress(host,port))
              .handler(new ChannelInitializer<SocketChannel>() {
                  @Override
                  protected void initChannel(SocketChannel ch) throws Exception {
                      ch.pipeline().addLast(
                              new EchoClientHandler());
                  }
              });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws  Exception{
        if(args.length != 2){
            System.err.println(
           "Usage :"+EcoClient.class.getSimpleName()+"<host><port>"
            );
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EcoClient("127.0.0.1",8080).start();
    }
}
