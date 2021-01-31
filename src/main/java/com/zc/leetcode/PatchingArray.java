package com.zc.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 330. 按要求补齐数组
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 *
 * 示例 2:
 *
 * 输入: nums = [1,5,10], n = 20
 * 输出: 2
 * 解释: 我们需要添加 [2, 4]。
 *
 * 示例 3:
 *
 * 输入: nums = [1,2,2], n = 5
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/patching-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2020/12/29 11:25
 * @modified
 */
public class PatchingArray {

    //超时
    public int minPatches(int[] nums, int n) {
        Set<Integer> resultSet = new TreeSet<>();
        boolean[] booleanArrays = new boolean[nums.length];
        backtrack(nums, resultSet, booleanArrays, 0, nums.length-1);

        int ret = 0;
        int index = 1;
        while (resultSet.size()<n){
            if (!resultSet.contains(index)){
                ret++;
                Set<Integer> addSet = new HashSet<>();
                addSet.add(index);
                for (Integer value : resultSet){
                    if (index+value>n){
                        break;
                    }
                    if (!resultSet.contains(index+value)){
                        addSet.add(index+value);
                    }
                }

                resultSet.addAll(addSet);
            }

            index++;
        }
        return ret;
    }

    //回溯
    private void backtrack(int[] nums, Set<Integer> resultSet, boolean[] booleanArrays, int left, int right){
        if (left>right){
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (booleanArrays[i]){
                    sum+=nums[i];
                }
            }
            if (sum!=0) {
                resultSet.add(sum);
            }
        }else {
            booleanArrays[left] = true;
            backtrack(nums, resultSet, booleanArrays, left+1, right);
            booleanArrays[left] = false;
            backtrack(nums, resultSet, booleanArrays, left+1, right);
        }
    }

    /**
     * 这题让从数组中找出任意数字都可以组成n，题中说了，数组是排序的。
     *
     * 假设数组中前k个数字能组成的数字范围是[1,total]，当我们添加数组中第k+1个数字nums[k](数组的下标是从0开始的)的时候，范围就变成了[1,total]U[1+nums[k],total+nums[k]]U[nums[k],nums[k]]，这是个并集，可以合并成[1,total]U[nums[k],total+nums[k]]，我们仔细观察一下
     *
     * 1，如果左边的total<nums[k]-1，那么他们中间肯定会有空缺，不能构成完整的[1，total+nums[k]]。
     * 举个例子
     * [1,5]U[7,10]，因为5<7-1，所以是没法构成[1,10]的
     *
     * 这个时候我们需要添加一个数字total+1。先构成一个更大的范围[1，total*2+1]。
     * 这里为什么是添加total+1而不是添加total，我举个例子，比如可以构成的数字范围是[1,5]，如果需要添加一个构成更大范围的，我们应该选择6而不是选择5。
     *
     * 2，如果左边的total>=nums[k]-1，那么就可以构成完整的[1，total+nums[k]]，就不需要在添加数字了。
     *
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-tan-xin-suan-fa-b4bwr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param n
     */
    public int minPatches2(int[] nums, int n) {
        //推进的最大结果
        long maxValue = 0;
        //选取nums下标
        int index = 0;
        //需要添加的数量
        int ret = 0;
        while (maxValue<n){
            if (index<nums.length && nums[index]<=maxValue+1){
                maxValue = nums[index++]+maxValue;
            }else {
                //需要添加一个值maxValue+1
                ret++;
                maxValue = maxValue + (maxValue+1);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        PatchingArray patchingArray = new PatchingArray();
        patchingArray.minPatches(new int[]{1,5,10},20);
    }
}
