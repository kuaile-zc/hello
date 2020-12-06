package com.zc.leet;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Description:
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度为 3 的子序列，其中每个子序列都由连续整数组成。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-06 22:25
 */
public class SplitArray {
    //哈希最小堆栈  map key子序列最后一个数组  value最小堆子序列长度
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> retMap = new HashMap<>();
        for (int i : nums){
            if (!retMap.containsKey(i)){
                retMap.put(i,new PriorityQueue<>());
            }

            //获取前一个
            if (retMap.containsKey(i-1)){
                Integer prevLength = retMap.get(i - 1).poll();
                if (retMap.get(i-1).isEmpty()){
                    retMap.remove(i-1);
                }
                retMap.get(i).offer(prevLength+1);
            }else {
                retMap.get(i).offer(1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : retMap.entrySet()){
            PriorityQueue<Integer> value = entry.getValue();
            if (value.peek()<3){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        SplitArray splitArray = new SplitArray();
//        splitArray.isPossible(new int[]{1,2,3,3,4,4,5,5});
    }

}
