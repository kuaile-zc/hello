package com.zc.thread.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/19 10:56
 * @modified
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
//        Test1();
        test2();
    }

    //主线程等待子线程执行完成后再执行
    public static void test1(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable =  new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println("The child thread "+ Thread.currentThread().getName() + "  begin..");
                        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                        System.out.println("The child thread "+ Thread.currentThread().getName() + " finish.....");
                        //计数器减一
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            System.out.println("The main thread"+ Thread.currentThread().getName() + "await.....");
            //阻塞直到计数器的值为0
            countDownLatch.await(20,TimeUnit.SECONDS);
            System.out.println("The main thread"+ Thread.currentThread().getName() + " begin..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }

    //例子2
    //百米赛跑，4名运动员选手到达场地等待裁判口令，裁判一声口令，选手听到后同时起跑，当所有选手到达终点，裁判进行汇总排名
    public static void test2(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        final CountDownLatch runOrder = new CountDownLatch(1);
        final CountDownLatch finishOrder = new CountDownLatch(4);

        for (int i = 0; i < 4; i++) {
            Runnable runnable =  new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println("The runner "+ Thread.currentThread().getName() + "  toe the line..");
                        runOrder.await();
                        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                        System.out.println("The runner "+ Thread.currentThread().getName() + " finish match.....");
                        //计数器减一
                        finishOrder.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
            System.out.println("The judgment "+ Thread.currentThread().getName() + "  begin playing..");
            runOrder.countDown();
            System.out.println("The judgment "+ Thread.currentThread().getName() + "  waiting for all runners to reach the finish line..");
            finishOrder.await();
            System.out.println("The judgment "+ Thread.currentThread().getName() + "  end of the game..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
