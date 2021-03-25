package com.zc.netty.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/24 0:47
 * @modified
 */
public class GroupChatClient {

    //连接ip端口
    private static String HOST = "127.0.0.1";
    private static int PORT = 6667;

    private SocketChannel socketChannel;
    private String username;


    public void client() {

        try {
            socketChannel = SocketChannel.open();
//            socketChannel.configureBlocking(false);

            socketChannel.connect(new InetSocketAddress(HOST, PORT));

            while (!socketChannel.finishConnect()) {
                System.out.println("Client do other thing!");
            }

            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println("I'm is " + username);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String readMsg = read(socketChannel);
                            System.out.println(readMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    ByteBuffer buffer = ByteBuffer.wrap(line.getBytes(StandardCharsets.UTF_8));
                    socketChannel.write(buffer);
                } else {
                    Thread.sleep(1000);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //读到服务端的消息
    private String read(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count = socketChannel.read(buffer);
        String msg = new String(buffer.array()).substring(0, count);
        return msg;
    }

    public static void main(String[] args) {
        GroupChatClient groupChatClient = new GroupChatClient();
        groupChatClient.client();
    }
}
