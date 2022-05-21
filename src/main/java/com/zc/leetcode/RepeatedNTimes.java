package com.zc.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author corey
 * @creat 2022/5/21 17:19
 * @describe https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedNTimes {

    public static void main(String[] args) {

    }

    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (null != map.get(num)) {
                return num;
            }else {
                map.put(num, 0);
            }
        }
        return 0;
    }
}
