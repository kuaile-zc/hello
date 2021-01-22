package com.zc.leetcode;

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
    //暴力 将两倍的最大值存起来 超时
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

    //归并排序
    public int reversePairs2(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length-1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right){
        if (left == right){
            return 0;
        }

        int middle = (left + right)/2;
        int leftValue = reversePairsRecursive(nums, left, middle);
        int rightValue = reversePairsRecursive(nums, middle+1, right);

        int ret = leftValue + rightValue;
        int leftIndex = left;
        int rightIndex = middle+1;

        //计算两个数组之间的翻转对
        while (leftIndex <= middle){
            while (rightIndex <= right && (long)nums[leftIndex] > (long)2*nums[rightIndex]){
                rightIndex++;
            }
            ret += rightIndex - (middle+1);
            leftIndex++;
        }

        //归并数组
        int leftSortIndex = left;
        int rightSortIndex = middle+1;
        int[] temp = new int[right - left +1];
        int index = 0;
        while (leftSortIndex<=middle && rightSortIndex<=right){
            if (nums[leftSortIndex]<nums[rightSortIndex]){
                temp[index++] = nums[leftSortIndex++];
            }else {
                temp[index++] = nums[rightSortIndex++];
            }
        }
        //清空左边或者右边的数组
        while (leftSortIndex<=middle){
            temp[index++] = nums[leftSortIndex++];
        }
        while (rightSortIndex<=right){
            temp[index++] = nums[rightSortIndex++];
        }


        index = 0;
        for (int i=0; i<temp.length; i++){
            nums[left++] = temp[index++];
        }


        return ret;

    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        reversePairs.reversePairs2(new int[]{1,3,2,3,1});
    }
}
