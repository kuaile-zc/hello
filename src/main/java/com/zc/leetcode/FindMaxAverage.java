package com.zc.leetcode;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 * 提示：
 *
 *     1 <= k <= n <= 30,000。
 *     所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/4 10:46
 * @modified
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum= 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        maxSum = sum;
        for (int i = k; i<nums.length; i++){
            sum+= nums[i] - nums[i-k];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0d*maxSum/k;
    }
}
