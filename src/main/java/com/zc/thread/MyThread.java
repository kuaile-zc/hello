package com.zc.thread;

/**
 * @author CoreyChen Zhang
 * @version 2021/1/14 19:53
 * @modified
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i="+i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        System.out.println("第一次调用thread.isInterrupted()："+myThread.isInterrupted());
        System.out.println("第二次调用thread.isInterrupted()："+myThread.isInterrupted());
        System.out.println("thread是否存活："+myThread.isAlive());
    }
}
