package com.zc.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering: 将数据写入buffer的时候， 可以采用buffer数组 分散写入
 * Gathering 从buffer读取数据是，采用buffer数组
 * @Author CoreyChen Zhang
 * @Date: 2021/03/10/ 22:25
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel 用于分配SocketChannel 网络通信
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket ，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLange = 8;
        //循环读取
        while (true){
            int byteRead = 0;
            int byteWrite = 0;
            while (byteRead < messageLange){
                long length = socketChannel.read(byteBuffers);
                byteRead += length;
                System.out.println("byteRead=" + byteRead);
                //打印 buffer position 和 limit
                Arrays.stream(byteBuffers).map(buffer ->
                        "position 和 limit:"+ buffer.position()+"   "+buffer.limit())
                        .forEach(System.out::println);

                //将所有的buffer翻转
                Arrays.stream(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());

                //将数据读出
                while (byteWrite<messageLange){
                    long write = socketChannel.write(byteBuffers);
                    write +=1;
                }

                Arrays.stream(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
                System.out.println();
            }

        }

    }
}
