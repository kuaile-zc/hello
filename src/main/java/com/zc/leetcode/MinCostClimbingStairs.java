package com.zc.leetcode;

/**
 * Description:
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-21 0:25
 */
public class MinCostClimbingStairs {
    //动态规划
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        //初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i<length; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[length-2], dp[length-1]);
    }

    //动态规划压缩
    public int minCostClimbingStairs2(int[] cost) {
        int length = cost.length;
        //初始化
        int dp1 = cost[0];
        int dp2 = cost[1];
        for (int i = 2; i<length; i++){
            int temp = dp2;
            dp2 = Math.min(dp1, dp2) + cost[i];
            dp1 = temp;
        }

        return Math.min(dp1, dp2);
    }
}
