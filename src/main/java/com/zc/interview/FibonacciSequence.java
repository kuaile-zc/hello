package com.zc.interview;

/**
 * Description:1,1,2,3,5,8,13,21,34,55
 *
 * @author Corey Zhang
 * @create 2020-05-18 21:19
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacciSequenceFunction(10));
    }

    public static int fibonacciSequenceFunction(int n){
        if (n == 0 || n==1){
            return n;
        }

        return fibonacciSequenceFunction(n-1)+fibonacciSequenceFunction(n-2);
    }

}
