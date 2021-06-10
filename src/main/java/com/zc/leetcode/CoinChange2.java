package com.zc.leetcode;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * <p>
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * <p>
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @date 2021/6/10 10:31
 * @modified
 */
public class CoinChange2 {

    //使用滚动数组
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[] dp = new int[amount + 1];
        //初始化
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        coinChange2.change(5, new int[]{1, 2, 5});
    }
}
