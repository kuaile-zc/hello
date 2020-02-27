package com.zc.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-02-27 15:59
 */
public class Meters {

    public static Random random = new Random();

    public static void request(Meter meter){
        System.out.println("request");
        meter.mark();
    }

    public static void request(Meter meter,int n){
        while (n > 0){
            request(meter);
            n--;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        Meter meter = registry.meter(MetricRegistry.name(Meter.class,"request","tps"));

        while (true){
            request(meter,5);
            Thread.sleep(1000);
        }

    }
}
