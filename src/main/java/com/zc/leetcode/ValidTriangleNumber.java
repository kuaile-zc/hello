package com.zc.leetcode;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * 注意:
 *
 *     数组长度不超过1000。
 *     数组里整数的范围为 [0, 1000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/8/4 10:51
 * @modified
 */
public class ValidTriangleNumber {

    //暴力法
    public int triangleNumber(int[] nums) {
        int length = nums.length, result = 0;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < length - 1 ; j++) {
                int b = nums[j];
                for (int k = j + 1; k < length; k++) {
                    if ( nums[k]< a+b) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        validTriangleNumber.triangleNumber(new int[]{2,2,3,4});
    }
}
