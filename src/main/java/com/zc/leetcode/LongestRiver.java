package com.zc.leetcode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 *     若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 *     或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 *
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 40000
 *     0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/20 14:29
 * @modified
 */
public class LongestRiver {

    //动态规划
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length , maxValue = 1;
        //定义动态规划数组第二维数组0表示上升，1表示下降
        int[][] dp = new int[length][2];
        //初始化
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i=1; i<length; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            if (arr[i]<arr[i-1]){
                dp[i][1] = dp[i-1][0] + 1;
                maxValue = Math.max(maxValue, dp[i][1]);
            }else if (arr[i]>arr[i-1]){
                dp[i][0] = dp[i-1][1] + 1;
                maxValue = Math.max(maxValue, dp[i][0]);
            }
        }

        return maxValue;

    }

    //空间压缩
    public int maxTurbulenceSize2(int[] arr) {
        int length = arr.length;
        int up = 1, down = 1, ret =1;
        for(int i=1; i<length; i++){
            if(arr[i]==arr[i-1]){
                up = 1;
                down = 1;
                continue;
            }else if(arr[i]>arr[i-1]){
                up = down + 1;
                down = 1;
                ret = Math.max(ret, up);
            }else{
                down = up + 1;
                up =1;
                ret = Math.max(ret, down);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestRiver longestRiver = new LongestRiver();
        longestRiver.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9});
    }
}
