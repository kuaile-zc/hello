package com.zc.thread.util;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/9 15:50
 * @modified
 */
public class TestThread extends Thread {

    private SemaphoreConnectPool pool = new SemaphoreConnectPool(2);

    @Override
    public void run() {
        try {
            SemaphoreConnectPool.Connect connect = pool.openConnect();
            Thread.sleep(5000);  //休息一下
            pool.release(connect);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
