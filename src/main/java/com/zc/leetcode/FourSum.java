package com.zc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/27 10:09
 * @modified
 */
public class FourSum {
    //自己写的 分组 + 哈希表
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        if (length==0){
            return 0;
        }
        //创建结果集  结果 数量
        Map<Integer, Integer> tempMap1 = new HashMap<>();
        Map<Integer, Integer> tempMap2 = new HashMap<>();
        Map<Integer, Integer> retMap1 = new HashMap<>();
        Map<Integer, Integer> retMap2 = new HashMap<>();

        for (int i=0; i<length; i++){
            if (null == tempMap1.get(A[i])){
                tempMap1.put(A[i],1);
            }else {
                tempMap1.put(A[i], tempMap1.get(A[i])+1);
            }

            if (null == tempMap2.get(C[i])){
                tempMap2.put(C[i],1);
            }else {
                tempMap2.put(C[i], tempMap2.get(C[i])+1);
            }

        }

        for (int i=0; i<length; i++){
            int value1 = B[i];
            int value2 = D[i];
            for (Map.Entry<Integer, Integer> entry : tempMap1.entrySet()){
                int add = value1 + entry.getKey();
                if (null == retMap1.get(add)){
                    retMap1.put(add,entry.getValue());
                }else {
                    int number = retMap1.get(add)+entry.getValue();
                    retMap1.put(add, number);
                }
            }

            for (Map.Entry<Integer, Integer> entry : tempMap2.entrySet()){
                int add = value2 + entry.getKey();
                if (null == retMap2.get(add)){
                    retMap2.put(add,entry.getValue());
                }else {
                    int number = retMap2.get(add)+entry.getValue();
                    retMap2.put(add, number);
                }
            }
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : retMap1.entrySet()){
            int sub = 0 - entry.getKey();
            if (retMap2.get(sub) != null){
                ret = ret + entry.getValue()*retMap2.get(sub);
            }
        }


        return ret;

    }

    //官方写的 分组 + 哈希表
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        if (length==0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0) + 1);
            }
        }

        int ret = 0;
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                int value = C[i] + D[j];
                if (map.containsKey(-value)){
                    ret += map.get(-value);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        fourSum.fourSumCount(new int[]{1,2,1}, new int[]{-1,4,0}, new int[]{0,2,3}, new int[]{1,-1,-2});
    }
}
