package com.zc.leetcode;

import java.util.Arrays;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 *     例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 20
 *     0 <= nums[i] <= 1000
 *     0 <= sum(nums[i]) <= 1000
 *     -1000 <= target <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/06/07/ 23:13
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum(), length = nums.length;

        if (Math.abs(target) > sum){
            return 0;
        }
        int t = 2*sum + 1;
        int[][] dp = new int[length][t];
        //初始化
        dp[0][sum - nums[0]]++;
        dp[0][sum + nums[0]]++;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < t; j++) {
                int l = (j-nums[i]) >= 0 ? j-nums[i] : 0;
                int r = (j+nums[i]) < t ? j+nums[i] : 0;
                dp[i][j] = dp[i-1][l] + dp[i-1][r];
            }
        }
        return dp[length-1][sum + target];
    }
}
