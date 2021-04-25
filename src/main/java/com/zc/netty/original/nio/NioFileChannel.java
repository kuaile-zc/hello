package com.zc.netty.original.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 通道案例
 * 对照网易云笔记图
 * netty学习
 *
 * @Author CoreyChen Zhang
 * @Date: 2021/03/09/ 23:45
 */
public class NioFileChannel {

    final static String FILE_PATH = "d:\\nettyTest\\file01.txt";
    final static String IMAGE_PATH = "d:\\nettyTest\\aa.jpg";
    final static String IMAGE2_PATH = "d:\\nettyTest\\aaCope.jpg";

    public static void main(String[] args) throws IOException {
        String str = "Hello!";
        //创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
        //创建channel包裹输出流  fileChannel 真实类型是 FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将Str 放入buffer  (1)
        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
        //对buffer翻转
        byteBuffer.flip();

        //将buffer数据写入channel （2） 记住channel的读写都是针对buffer为主体这么去思考
        channel.write(byteBuffer);
        fileOutputStream.close();

        readChannelBuffer();
        copy();

    }

    //自己写一个读取
    private static void readChannelBuffer() throws IOException {
        //创建一个文件读取流
        File file = new File(FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);

        //创建 channel
        FileChannel channel = fileInputStream.getChannel();

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //读取
        channel.read(byteBuffer);
        //翻转
        byteBuffer.flip();

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();

    }

    private static void copy() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(IMAGE_PATH);
        FileOutputStream fileOutputStream = new FileOutputStream(IMAGE2_PATH);

        FileChannel source = fileInputStream.getChannel();
        FileChannel copy = fileOutputStream.getChannel();

        copy.transferFrom(source, 0, source.size());
        //关闭
        source.close();;
        copy.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
