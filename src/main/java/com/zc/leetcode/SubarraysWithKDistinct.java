package com.zc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 992. K 个不同整数的子数组
 *
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 20000
 *     1 <= A[i] <= A.length
 *     1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/9 10:40
 * @modified
 */
public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        SlidData slidData = new SlidData();
        int length = A.length, ret = 0, left = 0, right = 0;
        while (true) {
            if (right<=length && left<length){
                if (right<length && slidData.preAdd(A[right], K)){
                    slidData.add(A[right]);
                }else {
                    right--;
                    slidData.removeFirst(A[left++]);
                    while (right>left && slidData.black(A[right], K)){
                        right--;
                    }
                }
                if (K == slidData.getSize()){
                    ret++;
                }
                right++;
            }else {
                break;
            }
        }

        return ret;
    }

    class SlidData{
        private Map<Integer, Integer> map = new HashMap<>();
        //加载
        public void add(int i){
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else {
                map.put(i, map.get(i) +1);
            }
        }

        //预加载
        public boolean preAdd(int i, int k){
            if (getSize()==k && !map.containsKey(i)){
                return false;
            }
            return true;
        }
        //删除
        public void removeFirst(int i){
            Integer numb = map.get(i);
            if (numb-1==0){
                map.remove(i);
            }else {
                map.put(i, numb-1);
            }
        }
        //回退
        public boolean black(int i, int k){
            Integer numb = map.get(i);
            if (numb-1==0|| getSize() < k){
                return false;
            }else {
                map.put(i, numb-1);
            }
            return true;
        }

        public int getSize(){
            return map.keySet().size();
        }


    }

    public static void main(String[] args) {
        SubarraysWithKDistinct subarraysWithKDistinct = new SubarraysWithKDistinct();
        subarraysWithKDistinct.subarraysWithKDistinct(new int[]{2,1,1,1,2}, 1);
    }
}
