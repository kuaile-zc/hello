package com.zc.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * 321. 拼接最大数
 *给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 *
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 *
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-02 22:22
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return null;
    }

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length && k>0; i++){

        }

        return null;
    }

    public static void main(String[] args) {
        CreateMaximumNumber createMaximumNumber = new CreateMaximumNumber();
        createMaximumNumber.maxNumber(new int[]{8,6,9}, new int[]{1,7,5}, 3);
    }
}
