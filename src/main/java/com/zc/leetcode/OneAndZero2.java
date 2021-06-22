package com.zc.leetcode;

/**
 * 474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @date 2021/6/7 10:47
 * @modified
 */
public class OneAndZero2 {

    //使用动态规划（滚动数组优化）
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int one = findOne(strs[i]);
            int zero = strs[i].length() - one;
            for (int k = m; k >= zero; k--) {
                for (int z = n; z >= one; z--) {
                    if (zero <= k && one <= z) {
                        dp[k][z] = Math.max(dp[k][z], dp[k - zero][z - one] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
    private int findOne (String str){
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

        public static void main (String[]args){
            OneAndZero2 oneAndZero2 = new OneAndZero2();
            oneAndZero2.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        }
    }
