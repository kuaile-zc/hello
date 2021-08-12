package com.zc.leetcode;

import java.util.Arrays;

/**
 * @author CoreyChen Zhang
 * @date 2021/8/9 15:11
 * @modified
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int length = primes.length;
        int[] multiple = new int[length], dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int[] nums = new int[length];
            for (int j = 0; j < length; j++) {
                nums[j] = dp[multiple[j]] * primes[j];
                min = Math.min(min, nums[j]);
            }
            dp[i] = min;
            for (int j = 0; j < length; j++) {
                if (min ==  nums[j]) {
                    multiple[j]++;
                }
            }

        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        superUglyNumber.nthSuperUglyNumber(12, new int[]{2,7,13,19});
    }
}
