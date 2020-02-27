package com.zc.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-02-27 16:40
 */
public class TimerTest {

    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(5,TimeUnit.SECONDS);

        Timer timer = registry.timer(MetricRegistry.name(TimerTest.class,"get-latency"));

        Timer.Context ctx;

        while (true){
            ctx = timer.time();
            Thread.sleep(random.nextInt(5000));
            ctx.stop();
        }
    }
}
