package com.zc.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-02-27 15:23
 */
public class CounterTest {

    public static Queue<String> queue = new LinkedList<String>();

    public static Counter pendingJobs;

    public static Random random = new Random();

    public static void addJob(String job){
        pendingJobs.inc();
        queue.offer(job);
    }

    public static String takeJob(){
        pendingJobs.dec();
        return queue.poll();
    }


    public static void main(String[] args) throws InterruptedException {

        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1,TimeUnit.SECONDS);

        pendingJobs = registry.counter(MetricRegistry.name(Queue.class,"pending-jobs","size"));

        int num = 1;

        while (true){
            Thread.sleep(200);

            if (random.nextDouble() > 0.7){
                String job = takeJob();
                System.out.println("take job :"+ job);
            }else {
                String job = "Job-" + num;
                addJob(job);
                System.out.println("add job :"+ job);
            }

            num++;

        }
    }
}
