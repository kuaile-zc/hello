package com.zc.leet;

import java.util.Map;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 * 注意:
 *
 *     给定数组的长度不会超过50000。
 *     输入数组中的所有数字都在32位整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/28 10:54
 * @modified
 */
public class ReversePairs {
    //暴力 将两倍的最大值存起来
    public int reversePairs(int[] nums) {
        int length = nums.length;
        if (length < 2){
            return 0;
        }
        int[] ret = new int[length];
        int indexMax = nums[0];
        for (int i=1; i<length; i++){
            indexMax = Math.max(indexMax, nums[i]);
            long value = (long) nums[i]*2;
            int num = 0;
            if (indexMax>value){
                for (int j=0; j<i; j++){
                    if (nums[j]> value){
                        num++;
                    }
                }
            }

            ret[i] = ret[i-1] + num;
        }

        return ret[length-1];
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        reversePairs.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647});
    }
}
