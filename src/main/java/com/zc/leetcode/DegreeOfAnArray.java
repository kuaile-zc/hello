package com.zc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 697. 数组的度
 *
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 *
 * 提示：
 *
 *     nums.length 在1到 50,000 区间范围内。
 *     nums[i] 是一个在 0 到 49,999 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/20 10:14
 * @modified
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        //第一步记录所有度
        int length = nums.length, maxNum=1, ret=length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                Integer integer = map.get(num)+1;
                if (maxNum<integer){
                    maxNum = integer;
                }
                map.put(num, integer);
            }
        }
        //第二步从左右开始缩圈缩圈找到最左边和最右边的
       for (Map.Entry<Integer, Integer> kv :map.entrySet()){
           if (maxNum==kv.getValue()){
               int target = kv.getKey();
               int left = 0;
               int right = length-1;
               while (nums[left]!=target){
                   left++;
               }
               while (nums[right]!=target){
                   right--;
               }
               ret = Math.min(right-left+1, ret);
           }
       }

        return ret;
    }

    //官网思路
    public int findShortestSubArray2(int[] nums) {
        //第一步记录所有度
        int length = nums.length, maxNum=1, minLen=length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{ 1, i, i});
            }else {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
        }
        //第二步从左右开始缩圈缩圈找到最左边和最右边的
        for (Map.Entry<Integer, int[]> kv :map.entrySet()){
            if (maxNum< kv.getValue()[0]){
                maxNum = kv.getValue()[0];
                minLen = kv.getValue()[2] - kv.getValue()[1] + 1;
            }else if (maxNum == kv.getValue()[0]){
                if (kv.getValue()[2] - kv.getValue()[1] + 1<minLen){
                    minLen = kv.getValue()[2] - kv.getValue()[1] + 1;
                }
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        degreeOfAnArray.findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
