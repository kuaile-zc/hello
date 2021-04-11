package com.zc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 264. 丑数 II
 * <p>
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1690
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/4/11 9:16
 * @modified
 */
public class UglyNumber2 {

    //超时
    public int nthUglyNumber(int n) {
        int index = 1, result = 1, uglyNumb = 1;
        while (true) {
            if (result == n) {
                return uglyNumb;
            }
            index++;
            if (isUgly(index)){
                result++;
                uglyNumb = index;
            }
        }

    }

    private boolean isUgly(int n) {
        int cur = n;
        if (cur < 1) {
            return false;
        }
        while (cur % 2 == 0 || cur % 3 == 0 || cur % 5 == 0) {
            if (cur % 2 == 0) {
                cur = cur / 2;
            }
            if (cur % 3 == 0) {
                cur = cur / 3;
            }
            if (cur % 5 == 0) {
                cur = cur / 5;
            }
        }
        return cur == 1;
    }

    //动态规划
    public int nthUglyNumber2(int n) {
        int index = 1, twoIndex = 0, threeIndex = 0, fiveIndex = 0;
        int[] ret = new int[n];
        ret[0] = 1;
        while (index < n){
            int minValue = Math.min(ret[twoIndex]*2, Math.min(ret[threeIndex]*3, ret[fiveIndex]*5));
            ret[index++] = minValue;
            if (minValue == ret[twoIndex]*2) twoIndex++;
            if (minValue == ret[threeIndex]*3) threeIndex++;
            if (minValue == ret[fiveIndex]*5) fiveIndex++;
        }

        return ret[n-1];
    }
}
