package com.zc.leet;

import java.util.*;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/19 17:04
 * @modified
 */
public class LongestUp {

    //动态规划
    //状态方程 f(0) = Max{f(n)+ f(0)<f(n)?1:0, f(n-1)+ f(0)<f(n-1)?1:0}
    public int lengthOfLIS(int[] nums) {
        int length = nums.length, maxValue = 1;
        //记录结果集和最小点结果
        if (length == 0) {
            return 0;
        }
        //初始化结果集
        int[] dp = new int[length];
        Arrays.fill(dp,1);

        dp[0] = 1;
        for (int i=1; i<length; i++){
            int value = nums[i];
            for (int j=0; j<i; j++){
                if (value>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxValue = Math.max(maxValue, dp[i]);

        }
        return maxValue;
    }

    public static void main(String[] args) {
        LongestUp longestUp = new LongestUp();
        System.out.println(longestUp.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println();
    }
}
