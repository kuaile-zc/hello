package com.zc.leetcode;

import java.util.*;

/**
 * Description:
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-13 11:59
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
//        List<Integer> collect = Arrays.stream(nums).mapToObj(n -> (Integer) n).collect(Collectors.toList());
//        Set<Integer> set = new HashSet<>();
//        set.addAll(collect);
//        if (collect.size()==set.size()){
//            return false;
//        }
//
//        return true;



//        Set<Integer> set = new HashSet<>();
//        int n =0;
//        for (int i=0; i<nums.length; i++){
//            if (n != set.size()){
//                return true;
//            }
//            set.add(nums[i]);
//            n++;
//        }
//
//        return n!=set.size();

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i=0; i<nums.length; i++){
//            if (null != map.get(nums[i])){
//                return true;
//            }
//            map.put(nums[i], 0);
//        }
//
//        return false;

        int length = nums.length;
        if (length==0){
            return false;
        }
        Arrays.sort(nums);
        int maxLength = nums[length-1] - nums[0] + 1;
        if (length>maxLength){
            return true;
        }

        for (int i=1; i<length; i++){
            if (nums[i-1]==nums[i]){
                return true;
            }
        }

        return false;
    }
}
