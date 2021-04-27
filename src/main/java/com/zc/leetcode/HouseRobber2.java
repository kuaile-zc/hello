package com.zc.leetcode;

import java.util.Arrays;

/**
 * @author CoreyChen Zhang
 * @version 2021/4/15 9:41
 * @modified
 */
public class HouseRobber2 {

    //动态规划
    public int rob(int[] nums) {
        int length = nums.length, ret = 0;
        if (length <= 3){
            return Arrays.stream(nums).max().getAsInt();
        }
        //二维数组0表示偷1表示不偷   dp1表示从第一个开始倒数第二家结束
        int[][] dp = new int[length-1][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + nums[i], dp[i-1][0]);
            dp[i][1] = dp[i-1][0];
        }
        ret = Math.max(dp[length-2][0], dp[length-2][1]);

        dp = new int[length][2];
        dp[1][0] = nums[1];
        for (int i = 2; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + nums[i], dp[i-1][0]);
            dp[i][1] = dp[i-1][0];
        }
        ret = Math.max(ret, Math.max(dp[length-1][0], dp[length-1][1]));
        return ret;
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        houseRobber2.rob(new int[]{2,7,9,3,1});
    }
}
