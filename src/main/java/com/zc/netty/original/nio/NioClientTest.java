package com.zc.netty.original.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/16 23:29
 * @modified
 */
public class NioClientTest {

    public static void main(String[] args) throws IOException {

        //得到网络socket
        SocketChannel socketChannel = SocketChannel.open();

        //设置非阻塞
        socketChannel.configureBlocking(false);

        //设置网络ip 端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8081);

        if (!socketChannel.connect(inetSocketAddress)){

            while (!socketChannel.finishConnect()){
                System.out.println("Client do other thing!");
            }
        }

        //准备数据
        String message = "Hi, my friend!";
        //包裹数据
        ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
        //将buffer数据写入通道
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}

