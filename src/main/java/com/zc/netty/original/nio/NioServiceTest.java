package com.zc.netty.original.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试多路复用代码
 *
 * @author CoreyChen Zhang
 * @version 2021/3/16 18:00
 * @modified
 */
public class NioServiceTest {

    public static void main(String[] args) throws IOException {

        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8081));
        //设置非堵塞
        serverSocketChannel.configureBlocking(false);

        //获取选择器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            //等待新事件
            while (selector.select(1000) == 0) {
                System.out.println("Waiting for new events.....");
                continue;
            }

            //等待有外部连接进来
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                //是否是连接事件
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (socketChannel != null){
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                }

                //是否是读事件
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                    socketChannel.read(byteBuffer);
                    System.out.println("Channel  Data  : "+ socketChannel.hashCode()+ "   " + new String(byteBuffer.array()));
                }

                iterator.remove();
            }


        }


    }
}
