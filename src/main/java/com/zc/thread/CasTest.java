package com.zc.thread;

/**
 * 此文的目的就是了解CAS机制
 * @author CoreyChen Zhang
 * @version 2021/1/20 15:07
 * @modified
 */
public class CasTest {


    private static int unsafeCount = 0;

    private volatile int safeCount = 0;

    public static void main(String[] args) {
        CasTest casTest = new CasTest();
        casTest.unsafeRunThread();
        casTest.unsafeRunThread2();
    }

    public void unsafeRunThread(){
        for (int i=0; i<2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        unsafeCount++;
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The unsafeCount = "+unsafeCount);
    }


    public void unsafeRunThread2(){
        for (int i=0; i<2; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        synchronized (CasTest.class){
                            safeCount++;
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The safeCount = "+safeCount);
    }
}
