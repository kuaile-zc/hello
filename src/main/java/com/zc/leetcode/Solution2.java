package com.zc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 此类用于演示动态规划案例 LeetCode.403
 * @author CoreyChen Zhang
 * @version 2020/10/22 20:28
 * @modified
 */
public class Solution2 {
    public boolean canCross(int[] stones) {
        int length = stones.length;
        //创建一个Map
        Map<Integer, Set<Integer>> retMap = new HashMap<>(length);
        //初始化
        for (int i=0; i< length; i++){
            Set<Integer> set = new HashSet<>();
            retMap.put(i,set);
        }
        //初始化第一步
        retMap.get(0).add(0);

        //遍历河流石子的序号
        for (int i=0; i<length; i++){
            //遍历i这个石头下的步数
            for (Integer step : retMap.get(i)){
                for (int j = i+1; j < length &&  stones[j] - stones[i] <= step +1; j++){
                    if (stones[j] - stones[i] >= step -1){
                        retMap.get(j).add(stones[j] - stones[i]);
                    }
                }
            }
        }


        return retMap.get(length -1).size() > 0;
    }



}
