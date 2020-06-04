package com.zc.interview;

/**
 * Description:1*2*3*4*5*6=n!
 *
 * @author Corey Zhang
 * @create 2020-05-16 0:04
 */
public class FactorialAlgorithm {
    public static void main(String[] args) {
        factorial(10);
    }

    public static void factorial(int n){
        int sum = 1;
        for (int x = 1; x <= n; x++){
            sum = sum * x;
        }
        System.out.println(sum);
    }
}
