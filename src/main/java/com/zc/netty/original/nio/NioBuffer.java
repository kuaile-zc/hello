package com.zc.netty.original.nio;

import java.nio.IntBuffer;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/03/09/ 22:50
 */
public class NioBuffer {

    public static void main(String[] args) {
        //举一个简单的例 使用
        //创建一个Buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        //修改读数据
        //将buffer读写转换
        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println();
        }
    }
}
