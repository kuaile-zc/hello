package com.zc.Lambdas.stream.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Description:
 * @author Corey Zhang
 * @create 2019-04-20 14:59
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    //Need to be summed.
    private final long[] numbers;
    private final int star;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int star, int end) {
        this.numbers = numbers;
        this.star = star;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //This task responsible for the size of the sum portion
        int length = end - star;
        if (length<=THRESHOLD){
            //If the size of the rain or is equal the threshold
            //,the results are calculated sequentially.
            return computeSequentially();
        }

        //Create a new task that sums the first half of the array.
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers,star,star+length/2);

        //Create a new task that suns the second half of the array.
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers,star+length/2,end);

        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.compute();

        return rightResult+leftResult;
    }

    private long computeSequentially(){
        long sum = 0;
        for (int i = star; i< end; i++){
            sum+=numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n){
        long[] number = LongStream.rangeClosed(1,n).toArray();
        ForkJoinSumCalculator forkJoinTask =new ForkJoinSumCalculator(number);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(forkJoinTask);
    }
}
