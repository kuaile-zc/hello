package com.zc.Lambdas.stream.parallel;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author zc
 * @create 2019-04-16 21:23
 */
public class NumberStream {
    public static void main(String[] args) {
        System.out.println("Squential sim done in:"+measureSumPerf(NumberStream::sequentialSum,5000000L));
        System.out.println("iterate sim done in:"+measureSumPerf(NumberStream::iterativeSum,5000000L));
        System.out.println(" Parallel sim done in:"+measureSumPerf(NumberStream::parallelSum,5000000L));

    }

    public static long parallelSum(Long n){
        return  Stream.iterate(1L,i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long sequentialSum(long n){
        return  Stream.iterate(1L,i->i+1)
                .limit(n)
                .reduce(0L,Long::sum);
    }

    public static long iterativeSum(long n){
        long result = 0;
        for (long i = 0L;i<=n;i++){
            result  +=i;
        }
        return result;
    }

    public static long measureSumPerf(Function<Long,Long> adder,long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 0;i<10;i++){
            long start = System.currentTimeMillis();
            long sum = adder.apply(n);
            long duration = System.currentTimeMillis() -start;
            if (duration<fastest)
                fastest=duration;
        }
        return fastest;
    }
}
