package com.zc.leetcode;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/08/28/ 22:35
 */
public class RunningSumofArray {

    public int[] runningSum(int[] nums) {
        int sum = 0, length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }
}
