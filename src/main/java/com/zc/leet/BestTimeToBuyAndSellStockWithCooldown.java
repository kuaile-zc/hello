package com.zc.leet;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/01/09/ 17:19
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length<2){
            return 0;
        }

        int ret = 0;
        //第一个值对应天数 第二个对应买入卖出
        int[][] dp = new int[length+1][2];
        dp[0][0] = dp[1][0] = -prices[0];

        for (int i = 2; i <= length; i++) {
            int index = i-1;
            int maxBuy = Integer.MIN_VALUE;
            int maxSell = Integer.MIN_VALUE;
            for (int j=0; j<i; j++){
                if (j<i-1){
                    maxBuy = Math.max(maxBuy, dp[j][1]-prices[index]);
                }
                maxSell = Math.max(maxSell, dp[j][0]+prices[index]);
            }
            dp[i][0] = maxBuy;
            dp[i][1] = maxSell;
            ret = Math.max(ret, maxSell);
        }

        return ret;
    }
}
