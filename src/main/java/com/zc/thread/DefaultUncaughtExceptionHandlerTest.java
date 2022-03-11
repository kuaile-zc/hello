package com.zc.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author CoreyChen Zhang
 * @date 2022/3/11 23:56
 * @modified
 */
public class DefaultUncaughtExceptionHandlerTest implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new DefaultUncaughtExceptionHandlerTest());
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("The error had caught!");
            }
        });
        thread.start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
