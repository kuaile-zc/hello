package com.zc;

/**
 * Description:
 * 327. 区间和的个数
 *
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-11-08 0:40
 */
public class IntervalAnd {

    public static void main(String[] args) {
        IntervalAnd intervalAnd = new IntervalAnd();
        int[] nums = new int[]{-2,5,-1};
        intervalAnd.countRangeSum(nums, -2, 2);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        //创建前序和
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        return countRangeSum(sum, lower, upper, 0, sum.length -1);
    }

    public int countRangeSum(long[] sum , int lower, int upper, int left, int right){
        if (left == right){
            return 0;
        }

        int start1 = left;
        int end1 = (left + right)/2;
        int start2 = end1 + 1;
        int end2 = right;
        int leftRet = countRangeSum(sum, lower, upper, start1, end1);
        int rightRet = countRangeSum(sum, lower, upper, start2, end2);
        int ret = leftRet + rightRet;

        int valueIndex = start2;
        int leftIndex = start1;
        int rightIndex = start1;

        //判断位置并记下可能
        while (valueIndex <= end2){

            while (leftIndex <= end1 && sum[valueIndex] - sum[leftIndex] >= lower){
                leftIndex++;
            }
            while (rightIndex <= end1 && sum[valueIndex] -sum[rightIndex] <= upper){
                rightIndex++;
            }

            ret = ret + rightIndex - leftIndex;
            valueIndex++;
        }


        //归并排序最后一步排序
        long[] temp = new long[right - left + 1];
        int index = 0;
        while (start1 <= end1 && start2 <= end2){
            temp[index++] = sum[start1] < sum[start2] ? sum[start1++] : sum[start2++];
        }
        while (start1 <= end1){
            temp[index++] = sum[start1++];
        }
        while (start2 <= end2){
            temp[index++] = sum[start2++];
        }

        for (int i = 0; i < temp.length; i++){
            sum[start1 + i] = temp[i];
        }

        return ret;

    }


}
