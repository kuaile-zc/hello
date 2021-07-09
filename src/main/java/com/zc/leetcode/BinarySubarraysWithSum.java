package com.zc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 *
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 * 示例 2：
 *
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 3 * 104
 *     nums[i] 不是 0 就是 1
 *     0 <= goal <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/7/8 10:11
 * @modified
 */
public class BinarySubarraysWithSum {

    //暴力
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0, length = nums.length;
        for (int left = 0; left < length; left++) {
            int curSum = 0, right = left;
            while (curSum <= goal && right < length) {
                curSum += nums[right];
                if (curSum == goal) {
                    result++;
                }
                right++;
            }
        }
        return result;
    }

    //哈希前缀和
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int result = 0, length = nums.length, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += nums[i];
            result += map.getOrDefault(sum - goal, 0);
        }
        return result;
    }

}
