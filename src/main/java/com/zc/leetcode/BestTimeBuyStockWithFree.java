package com.zc.leetcode;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 注意:
 *
 *     0 < prices.length <= 50000.
 *     0 < prices[i] < 50000.
 *     0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/17 10:21
 * @modified
 */
public class BestTimeBuyStockWithFree {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1; i<length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
        }

        return dp[length-1][1];
    }



    /**
     * 动态规划 压缩
     * dp[i][0]表示i天不持有股票可获得最大的利润 = max {前一天不持有股票的最大利润， 前一天持有股票然后今天卖掉  }
     * dp[i][1]表示i天持有股票可获得最大的利润  = max  {前一天持有股票的最大利润， 前一天不持有股票然后今天买股票  }
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i=1; i<length; i++){
            int temp = dp[0];
            dp[0] = Math.max(temp, dp[1]+prices[i]-2);
            dp[1] = Math.max(dp[1], temp-prices[i]);
        }

        return dp[0];

    }

    public static void main(String[] args) {
        BestTimeBuyStockWithFree bestTimeBuyStockWithFree = new BestTimeBuyStockWithFree();
        bestTimeBuyStockWithFree.maxProfit2(new int[]{1,2,7,5,10,3}, 3);
    }
}
