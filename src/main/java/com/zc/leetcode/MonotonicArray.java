package com.zc.leetcode;

/**
 * 896. 单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 *
 * 输入：[1,1,1]
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 50000
 *     -100000 <= A[i] <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/02/28/ 0:15
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        int length = A.length;
        if (length==1){
            return true;
        }
        int[] subArray = new int[length-1];
        for (int i = 0; i < length-1; i++) {
            subArray[i] = A[i] - A[i+1];
        }

        boolean isDesc = true;
        //全是正数或者0
        for (int i = 0; i < subArray.length; i++) {
            if (subArray[i]<0){
                isDesc = false;
                break;
            }
        }

        if (!isDesc){
            //全是负数或者0
            for (int i = 0; i < subArray.length; i++) {
                if (subArray[i]>0){
                    return false;
                }
            }
        }
        return true;
    }
}
