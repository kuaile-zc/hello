package com.zc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 *
 * 说明:
 *
 *     你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 *     请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/26 10:38
 * @modified
 */
public class MaximumGap {
    //暴力算法
    public int maximumGap(int[] nums) {
        int length = nums.length;
        if (length<2){
            return 0;
        }

        //自带排序
//        Arrays.sort(nums);
        RadixSort(nums);
        int ret = 0;
        for (int i=1; i<length; i++){
            ret = Math.max(ret, nums[i]-nums[i-1]);
        }

        return ret;
    }

    //基数排序（桶排序的衍生）
    private void RadixSort(int[] arrays){
        int length = arrays.length;

        //创建桶
        List<List<Integer>> bucket = new ArrayList<>(10);
        for (int i=0; i<10; i++){
            bucket.add(new ArrayList<Integer>());
        }

        //创建基数 的取余值和除数
        int rem = 10;
        int div = 1;

        int max = 0;
        for (int i=0; i<length; i++){
            max = Math.max(arrays[i], max);
        }

        //记录最大值的位数
        int digit = 0;
        while (max != 0){
            digit++;
            max = max/10;
        }

        //开始基数排序
        for (int i=0; i<digit; i++){
            //存到桶中
            for (int j=0; j<length; j++){
                int value = (arrays[j]%rem) / div;
                bucket.get(value).add(arrays[j]);
            }
            //从桶中释放出来
            int index = 0;
            for (int j=0; j<10; j++){
                List<Integer> list = bucket.get(j);
                for (int num : list){
                    arrays[index++] = num;
                }
                list.clear();
            }

            rem*=10;
            div*=10;
        }

    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        maximumGap.maximumGap(new int[]{1,1000});
    }
}
