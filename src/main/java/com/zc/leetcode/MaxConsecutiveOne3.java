package com.zc.leetcode;

/**
 * 1004. 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 20000
 *     0 <= K <= A.length
 *     A[i] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。    
 * @author CoreyChen Zhang
 * @version 2021/2/19 9:38
 * @modified
 */
public class MaxConsecutiveOne3 {

    public int longestOnes(int[] A, int K) {
        int length = A.length, ret=0, left=0, right=0, includeZero=0;
        while (right < length) {
            //判断当前数为0
            //两条路
            //1.如果includeZero 低于K那么可以right指针往前走
            //2.如果includeZero 等于K表示不能走但是left可以继续走（此时记录最长长度）但是要一直走到遇到0然后再循环
            if (A[right]==0){
                //1.路
                if (includeZero<K){
                    includeZero++;
                    right++;
                }else {
                    //2.路
                    ret = Math.max(ret, right-left);
                    while (A[left]==1 && left<right){
                        left++;
                    }
                    //防止K=0特殊情况
                    if (left==right){
                        right++;
                        left++;
                    }else {
                        left++;
                        includeZero--;
                    }
                }
            }else {
                right++;
            }
        }

        return ret<right-left ? right-left:ret;
    }

    public static void main(String[] args) {
        MaxConsecutiveOne3 maxConsecutiveOne3 = new MaxConsecutiveOne3();
        maxConsecutiveOne3.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 0);
    }
}
