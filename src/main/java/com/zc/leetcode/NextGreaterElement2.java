package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/6 15:21
 * @modified
 */
public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        if (length==0){
            return new int[0];
        }
        int[] ret = new int[length];
        Arrays.fill(ret, -1);
        for (int i = 0; i < length; i++) {
            int value = nums[i];
            for (int j = i+1; j <length+i ; j++) {
                int index = j;
                if (j>=length){
                    index = j-length;
                }
                if (nums[i] < nums[index]){
                    ret[i] = nums[index];
                    break;
                }
            }
        }
        return ret;

    }

    //单调栈
    public int[] nextGreaterElements2(int[] nums) {
        int length = nums.length;
        int[] ret = new int[length];
        Arrays.fill(ret, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 2 * length - 1; i++) {
            int index = i%length;
            while (!queue.isEmpty() && nums[queue.peekFirst()]<nums[index]){
                ret[queue.pollFirst()] = nums[index];
            }
            queue.addFirst(index);
        }

        return ret;

    }
}
