package com.zc.nio.timeServiceDemo.timeServiceMultiplexer;

import com.zc.nio.timeServiceDemo.Constant;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-01-05 17:45
 */
public class MultiplexerTimeService implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;


    /**
     * 初始化多路复用器，绑定监听端口
     * Initialize the multiplexer, bind the listener port
     */
    public MultiplexerTimeService(int port) {

        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time service is start in port : "+ port);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {

        while (!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it =  selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    }catch (Exception e){
                        if ( key != null){
                            key.cancel();
                            if (key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        //多路复用器关闭之后，所有注册在上面的Channel 和 Pipe 等资源都会被自动注册并关闭，所以不需要重复释放资源。
        if (selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    private void handleInput(SelectionKey key)throws IOException{
        if (key.isValid()){

            if (key.isAcceptable()){
                //Accept the new connection
                ServerSocketChannel ssc =  (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //Add the new connection to the selector.
                sc.register(selector, SelectionKey.OP_ACCEPT);
            }

            if (key.isReadable()){
                //Read the data
                SocketChannel sc =  (SocketChannel) key.channel();

                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readByte = sc.read(readBuffer);
                if (readByte > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : "+body);
                    String currentTime = Constant.QUERY_TIME_ORDER.equalsIgnoreCase(body) ? new Date().toString() : Constant.BAD_QUERY;
                    doWrite(sc, currentTime);

                }else if (readByte < 0){
                    key.cancel();
                    sc.close();
                }else {
                    //Not do anything.
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }


}
