package com.zc.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author CoreyChen Zhang
 * @version 2021/4/6 9:49
 * @modified
 */
public class RemoveDuplicatesFromSortedArray2 {

    //额外数组
    public int removeDuplicates(int[] nums) {
        int result = 0, length = nums.length, index = 0;
        LinkedList<Integer> ret = new LinkedList<>();
        while (index < length) {
            int value = nums[index], repeat = 1;
            while (index < length && nums[index] == value) {
                if (repeat < 3) {
                    ret.offer(nums[index]);
                }
                index++;
                repeat++;
            }
        }

        result = ret.size();
        for (int i = 0; i < result; i++) {
            nums[i] = ret.poll();
        }
        return result;
    }


    //快慢指针
    public int removeDuplicates2(int[] nums) {
        int result = 0, length = nums.length, indexLow = 2, indexFast = 2;
        if (length<=2){
            return length;
        }
        while (indexFast < length){
            while (indexFast < length && nums[indexFast] == nums[indexLow-2]){
                indexFast++;
            }
            if (indexFast < length && nums[indexFast] != nums[indexLow-2]){
                nums[indexLow] = nums[indexFast];
                indexLow++;
                indexFast++;
            }
        }
        return indexLow;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 removeDuplicatesFromSortedArray2 = new RemoveDuplicatesFromSortedArray2();
        removeDuplicatesFromSortedArray2.removeDuplicates2(new int[]{1, 1, 1});
    }

}
