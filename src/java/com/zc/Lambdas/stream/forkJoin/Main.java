package com.zc.Lambdas.stream.forkJoin;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2019-04-20 16:14
 */
public class Main {
    public static void main(String[] args) {
        long sum = ForkJoinSumCalculator.forkJoinSum(100_000_000);
        System.out.println(sum);
    }

}
