package com.zc.thread.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 简单的使用Semaphore
 * @author CoreyChen Zhang
 * @version 2021/2/9 14:54
 * @modified
 */
public class SemaphoreTest {

    private static final Semaphore semaphore = new Semaphore(5,true);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int id = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获得许可
                        semaphore.acquireUninterruptibly();
                        System.out.println("Accessing: "+ id);
                        //模拟业务逻辑
                        TimeUnit.SECONDS.sleep(5);
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        //释放锁
                        semaphore.release();
                    }
                }
            };
            executorService.execute(runnable);
        }

        executorService.shutdown();
    }
}
