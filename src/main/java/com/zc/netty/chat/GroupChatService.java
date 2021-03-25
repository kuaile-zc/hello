package com.zc.netty.chat;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * 1.编写服务器端
 * 1.1 服务器端启动并监听 6667
 * 1.2 服务器端接收客户信息，并实现转发[上线和离线]
 * 2.编写客户端
 * 2.1连接服务器
 * 2.2发送消息
 * 2.3接收消息
 *
 * @author CoreyChen Zhang
 * @version 2021/3/24 0:07
 * @modified
 */
public class GroupChatService {

    //服务监听器
    private ServerSocketChannel serverSocketChannel;
    private static int PORT = 6667;

    //轮询器
    private Selector selector;

    //创建服务器监听
    public void listen() {

        try {
            //创建接收器并绑定
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

            //设置福阻塞
            serverSocketChannel.configureBlocking(false);

            //创建轮询器
            selector = Selector.open();

            //将接收器注册到轮询器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //轮询接收
            while (true) {
                int select = selector.select();

                if (select > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();

                        //判断是否有客户端连接
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            System.out.println("Client into "+ socketChannel.getRemoteAddress());
                            socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        }

                        //读事件，读完之后写到其他所有的客户端
                        if (selectionKey.isReadable()){
                            read(selectionKey);
                        }

                        //这一步很关键
                        iterator.remove();

                    }

                } else {
//                    Thread.sleep(1000);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //读到客户端的消息
    private void read(SelectionKey selectionKey) throws IOException {

        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        String msg = "";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
//            socketChannel.configureBlocking(false);
            int count = socketChannel.read(buffer);
            msg = new String(buffer.array()).substring(0,count);
            System.out.println("from client " + socketChannel.getRemoteAddress().toString().substring(1)+ " : " + msg);
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress().toString().substring(1)+ " off line....");
                //关闭通道
                selectionKey.cancel();
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        write(msg, selectionKey);
    }

    //写到其他客户端
    private void write(String msg, SelectionKey self) throws IOException {
        SocketChannel socketChannel = (SocketChannel)self.channel();
        String s = socketChannel.getRemoteAddress().toString().substring(1) + " said " + msg;
        for (SelectionKey selectionKey : selector.keys()){
            SelectableChannel channel = selectionKey.channel();
            if (channel instanceof SocketChannel && selectionKey != self){
                ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8));
                ((SocketChannel) channel).write(byteBuffer);
            }
        }
    }


    public static void main(String[] args) {
        GroupChatService groupChatService = new GroupChatService();
        groupChatService.listen();
    }


}
