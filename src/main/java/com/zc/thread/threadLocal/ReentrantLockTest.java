package com.zc.thread.threadLocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/8 14:55
 * @modified
 */
public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock(true);
//    private static final Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> test(),"线程A").start();
        TimeUnit.SECONDS.sleep(600);
        new Thread(() -> test(),"线程B").start();
//        new Thread(() -> test(),"线程C").start();
//        new Thread(() -> test(),"线程D").start();
    }

    public static void test() {
        for (int i = 0; i < 2; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" get the lock!");
                TimeUnit.SECONDS.sleep(2);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }
}
