package com.zc.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author corey
 * @creat 2022/5/19 17:12
 * @describe TODO
 */
public class MinMoves2 {

    public int minMoves2(int[] nums) {
        final int length = nums.length;
        Arrays.sort(nums);
        int medNum = nums[length/2];
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.abs(nums[i] - medNum);
        }
        return result;
    }
}
