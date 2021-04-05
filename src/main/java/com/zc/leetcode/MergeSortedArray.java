package com.zc.leetcode;

import java.util.HashMap;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 *     nums1.length == m + n
 *     nums2.length == n
 *     0 <= m, n <= 200
 *     1 <= m + n <= 200
 *     -109 <= nums1[i], nums2[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/04/05/ 17:32
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int indexM1 = 0, indexM2 = 0, index = 0;
        while (indexM1 < m && indexM2 < n){
            if (nums1[indexM1] < nums2[indexM2]){
                result[index++] = nums1[indexM1++];
            }else {
                result[index++] = nums2[indexM2++];
            }
        }

        while (indexM1 < m){
            result[index++] = nums1[indexM1++];
        }

        while (indexM2 < n){
            result[index++] = nums2[indexM2++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }

    }
}
