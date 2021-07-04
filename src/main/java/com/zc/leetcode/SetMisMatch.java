package com.zc.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 645. 错误的集合
 *
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 *
 * 提示：
 *
 *     2 <= nums.length <= 104
 *     1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/07/04/ 19:33
 */
public class SetMisMatch {

    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int[] result = new int[2], map = new int[length+1];
        for (int i = 0; i < length; i++) {
            map[nums[i]]++;
        }

        for (int i = 1; i <= length; i++) {
            if (map[i] == 0){
                result[1] = i;
            }else if (map[i] == 2){
                result[0] = i;
            }
        }
        return result;
    }

    public int[] findErrorNums2(int[] nums) {
        int distinctSum = Arrays.stream(nums).distinct().sum();
        return new int[]{Arrays.stream(nums).sum() - distinctSum, IntStream.range(1, nums.length+1).sum() - distinctSum};

    }

    public static void main(String[] args) {
        SetMisMatch setMisMatch = new SetMisMatch();
        setMisMatch.findErrorNums2(new int[]{3,2,2});
    }
}
