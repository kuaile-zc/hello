package com.zc.threadLocal;

/**
 * Description: https://www.cnblogs.com/hama1993/p/10382523.html
 *
 * @author Corey Zhang
 * @create 2020-04-03 15:13
 */
public class ThreadLocalTest {

    public static ThreadLocal threadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal1.set(1);
        printMessage(Thread.currentThread().getName(), "main", threadLocal1.get());
        method();

        new Thread(() -> {
            threadLocal1.set(2);
            method();
        }

        ).start();

        Thread.sleep(1000L);

        method();

    }

    private static void method(){
        printMessage(Thread.currentThread().getName(), "method", threadLocal1.get());
    }

    public static void printMessage(String currentName, String methodName, Object data){
        System.out.println(String.format(
                "Current thread name: %s, %s method get threadLocal data: %s",
                currentName,
                methodName,
                data));
    }
}
