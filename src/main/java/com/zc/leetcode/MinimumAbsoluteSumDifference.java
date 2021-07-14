package com.zc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1818. 绝对差值和
 *
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 *     如果 x >= 0 ，值为 x ，或者
 *     如果 x <= 0 ，值为 -x
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 *
 * 示例 2：
 *
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 *
 * 示例 3：
 *
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 *
 *
 *
 * 提示：
 *
 *     n == nums1.length
 *     n == nums2.length
 *     1 <= n <= 105
 *     1 <= nums1[i], nums2[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/7/14 18:30
 * @modified
 */
public class MinimumAbsoluteSumDifference {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        long subSum = 0, length = nums1.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(nums1[i]);
            subSum = (subSum + Math.abs(nums1[i] - nums2[i]))%MOD;
        }
        if (subSum == 0){
            return 0;
        }

        int[] numArray = new int[set.size()];
        int index = 0, maxValue = Integer.MIN_VALUE;
        for (Integer i : set) {
            numArray[index++] = i;
        }
        Arrays.sort(numArray);
        for (int i = 0; i < length; i++) {
            int sub = Math.abs(nums1[i] - nums2[i]);
            maxValue = Math.max(maxValue, sub - findMinGap(numArray, nums2[i]));
        }
        return (int) (subSum - maxValue) % MOD;

    }

    private int findMinGap(int[] num, int target){
        int length = num.length, left = 0, right = length-1;
        while (right - left > 1){
            int half = (left + right)/2;
            if (target == num[half]){
                return 0;
            }else if (target > num[half]) {
                left = half;
            }else {
                right = half;
            }
        }

        return Math.min(Math.abs(num[right] - target), Math.abs(num[left] - target));
    }

    public static void main(String[] args) {
        MinimumAbsoluteSumDifference minimumAbsoluteSumDifference = new MinimumAbsoluteSumDifference();
        minimumAbsoluteSumDifference.minAbsoluteSumDiff(new int[]{57,42,21,28,30,25,22,12,55,3,47,18,43,29,20,44,59,9,43,7,8,5,42,53,99,34,37,88,87,62,38,68,31,3,11,61,93,34,63,27,20,48,38,5,71,100,88,54,52,15,98,59,74,26,81,38,11,44,25,69,79,81,51,85,59,84,83,99,31,47,31,23,83,70,82,79,86,31,50,17,11,100,55,15,98,11,90,16,46,89,34,33,57,53,82,34,25,70,5,1},
                                                        new int[]{76,3,5,29,18,53,55,79,30,33,87,3,56,93,40,80,9,91,71,38,35,78,32,58,77,41,63,5,21,67,21,84,52,80,65,38,62,99,80,13,59,94,21,61,43,82,29,97,31,24,95,52,90,92,37,26,65,89,90,32,27,3,42,47,93,25,14,5,39,85,89,7,74,38,12,46,40,25,51,2,19,8,21,62,58,29,32,77,62,9,74,98,10,55,25,62,48,48,24,21});
    }
}
