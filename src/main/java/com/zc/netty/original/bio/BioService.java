package com.zc.netty.original.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试Bio模式
 * @author CoreyChen Zhang
 * @version 2021/3/9 20:57
 * @modified
 */
public class BioService {
    //定制线程池
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 16, 1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws IOException {
        //线程池

        //思路
        //1.创建一个线程池
        //2.如果有客户端连接，就创建一个线程与通讯

        //创建一个serviceSocket
        ServerSocket serverSocket = new ServerSocket(8089);

        System.out.println("Service start......");

        while (true){
            final Socket socket = serverSocket.accept();

            System.out.println("Connect a client....");

            //创建一个线程
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }



    }

    //处理客户端
    public static void handler(Socket socket){
        byte[] bytes = new byte[1024];
        //获取输入流
        try {
            InputStream inputStream = socket.getInputStream();
            System.out.println("Thread ----"+ Thread.currentThread().getName());
            //读取数据
            while (true){
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(Thread.currentThread().getName()+ " send:  " + new String(bytes,0 ,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
