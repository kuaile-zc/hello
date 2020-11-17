package com.zc;

import java.util.Arrays;

/**
 * Description:
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 *
 * 提示：
 *
 *     1 <= prices.length <= 3 * 10 ^ 4
 *     0 <= prices[i] <= 10 ^ 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 方法二：贪心
 *
 * 由于股票的购买没有限制，因此整个问题等价于寻找 xxx 个不相交的区间 (li,ri](l_i,r_i](li​,ri​] 使得如下的等式最大化
 *
 * ∑i=1xa[ri]−a[li]\sum_{i=1}^{x} a[r_i]-a[l_i] i=1∑x​a[ri​]−a[li​]
 *
 * 其中 lil_ili​ 表示在第 lil_ili​ 天买入，rir_iri​ 表示在第 rir_iri​ 天卖出。
 *
 * 同时我们注意到对于 (li,ri](l_i,r_i](li​,ri​] 这一个区间贡献的价值 a[ri]−a[li]a[r_i]-a[l_i]a[ri​]−a[li​]，其实等价于 (li,li+1],(li+1,li+2],…,(ri−1,ri](l_i,l_i+1],(l_i+1,l_i+2],\ldots,(r_i-1,r_i](li​,li​+1],(li​+1,li​+2],…,(ri​−1,ri​] 这若干个区间长度为 111 的区间的价值和，即
 *
 * a[ri]−a[li]=(a[ri]−a[ri−1])+(a[ri−1]−a[ri−2])+…+(a[li+1]−a[li])a[r_i]-a[l_i]=(a[r_i]-a[r_i-1])+(a[r_i-1]-a[r_i-2])+\ldots+(a[l_i+1]-a[l_i]) a[ri​]−a[li​]=(a[ri​]−a[ri​−1])+(a[ri​−1]−a[ri​−2])+…+(a[li​+1]−a[li​])
 *
 * 因此问题可以简化为找 xxx 个长度为 111 的区间 (li,li+1](l_i,l_i+1](li​,li​+1] 使得 ∑i=1xa[li+1]−a[li]\sum_{i=1}^{x} a[l_i+1]-a[l_i]∑i=1x​a[li​+1]−a[li​] 价值最大化。
 *
 * 贪心的角度考虑我们每次选择贡献大于 000 的区间即能使得答案最大化，因此最后答案为
 *
 * ans=∑i=1n−1max⁡{0,a[i]−a[i−1]}\textit{ans}=\sum_{i=1}^{n-1}\max\{0,a[i]-a[i-1]\} ans=i=1∑n−1​max{0,a[i]−a[i−1]}
 *
 * 其中 nnn 为数组的长度。
 *
 * 需要说明的是，贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
 *
 * 考虑题目中的例子 [1,2,3,4,5][1,2,3,4,5][1,2,3,4,5]，数组的长度 n=5n=5n=5，由于对所有的 1≤i<n1 \le i < n1≤i<n 都有 a[i]>a[i−1]a[i]>a[i-1]a[i]>a[i−1]，因此答案为
 *
 * ans=∑i=1n−1a[i]−a[i−1]=4\textit{ans}=\sum_{i=1}^{n-1}a[i]-a[i-1]=4 ans=i=1∑n−1​a[i]−a[i−1]=4
 *
 * 但是实际的交易过程并不是进行 444 次买入和 444 次卖出，而是在第 111 天买入，第 555 天卖出
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-11-08 11:50
 */
public class MaxProfit {

    //贪心算法
    public int maxProfit(int[] prices) {
        //初始化结果集
        int[] ret = new int[prices.length - 1];
        //遍历每个单个结果
        for (int i = 0; i  < ret.length; i++){
            ret[i] =Math.max(0, prices[i+1] - prices[i]);
        }

        int max = 0;
        for (int i=0; i < ret.length; i++){
            max += ret[i];
        }
//        Arrays.sort();

        return max;
    }


}
