package com.zc.leetcode;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/7/16 17:03
 * @modified
 */
public class SearchTargetNumb {

    public int search(int[] nums, int target) {
        int length = nums.length, left = 0, right = length-1;
        while (left < right) {
            int half = left + (right - left)/2;
            if (nums[half] <= target - 1) {
                left = half + 1;
            }else {
                right = half - 1;
            }
        }
        if (nums[left] != target) {
            return 0;
        }
        int targetLeftIndex = left + 1;
        while (targetLeftIndex < length && nums[targetLeftIndex] == target) {
            targetLeftIndex++;
        }
        return targetLeftIndex - left;
    }

    public static void main(String[] args) {
        SearchTargetNumb searchTargetNumb = new SearchTargetNumb();
        searchTargetNumb.search(new int[]{5,7,7,7,8,8,10},7);
    }
}
