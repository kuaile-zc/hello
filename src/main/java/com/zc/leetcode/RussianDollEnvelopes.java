package com.zc.leetcode;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/4 9:42
 * @modified
 */
public class RussianDollEnvelopes {

    //思路动态规划
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length, ret=1;
        if (length<=1){
            return length;
        }
        Arrays.sort(envelopes, (a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1] );
        //dp代表以当前索引为最大的套娃
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0]> envelopes[j][0] && envelopes[i][1]> envelopes[j][1]){
                    max = Math.max(dp[j]+1, max);
                }
            }
            dp[i] = max;
            ret = Math.max(max, ret);
        }
        return ret;
    }

    //思路动态规划 - 升级版
    public int maxEnvelopes2(int[][] envelopes) {
        int length = envelopes.length, ret=1;
        if (length<=1){
            return length;
        }
        Arrays.sort(envelopes, (a,b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1] );
        //dp代表以当前 之前最大的套娃
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0]> envelopes[j][0] && envelopes[i][1]> envelopes[j][1]){
                    max = Math.max(dp[j]+1, max);
                }
            }
            dp[i] = max;
            ret = Math.max(max, ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        russianDollEnvelopes.maxEnvelopes(new int[][]{{10,8},{1,12},{6,15},{2,18}});
    }
}
