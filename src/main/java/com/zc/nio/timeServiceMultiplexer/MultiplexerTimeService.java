package com.zc.nio.timeServiceMultiplexer;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

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

    @Override
    public void run() {

    }
}
