package com.zc.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-02-27 15:02
 */
public class GaugeTest {

    public static Queue<String> queue = new LinkedList<String>();


    public static void main(String[] args) throws InterruptedException {

        MetricRegistry metricRegistry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).build();
        reporter.start(1,TimeUnit.SECONDS);

        metricRegistry.register(MetricRegistry.name(GaugeTest.class, "queue", "size"), new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return queue.size();
            }
        });

        while (true){
            Thread.sleep(1000);
            queue.add("Name");
        }

    }
}
