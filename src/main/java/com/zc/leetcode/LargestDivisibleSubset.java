package com.zc.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author CoreyChen Zhang
 * @date 2021/4/23 9:34
 * @modified
 */
public class LargestDivisibleSubset {

    //动态规划
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length, maxNumb = 1, maxValue = nums[0];
        Arrays.sort(nums);
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > maxNumb) {
                maxNumb = dp[i];
                maxValue = nums[i];
            }
        }

        int tempMaxValue = maxValue;
        int tempMaxRet = maxNumb;
        List<Integer> result = new ArrayList<>(maxNumb);
        for (int i = length - 1; i >= 0 && tempMaxRet>0; i--) {
            if (tempMaxValue % nums[i] == 0 && dp[i] == tempMaxRet) {
                result.add(nums[i]);
                tempMaxValue = nums[i];
                tempMaxRet--;
            }
        }
        return result;
    }
}
