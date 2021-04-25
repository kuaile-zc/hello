package com.zc.netty.original.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明
 * 1.可以让文件直接在内存修改（操作系统免去了os和用户端修改）俗称零拷贝
 * @Author CoreyChen Zhang
 * @Date: 2021/03/10/ 0:44
 */
public class MappedByteBufferTest {

    final static String FILE_PATH = "d:\\nettyTest\\file01.txt";

    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile(FILE_PATH, "rw");
        //获取对应的通道
        FileChannel channel = rw.getChannel();

        //1.读写模式  2.被修改的起始位置  3.映射到堆外内存的大小
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(2, (byte) '9');

        rw.close();

    }
}
