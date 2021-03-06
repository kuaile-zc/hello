package com.zc.leetcode;

/**
 * 263. 丑数
 *
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 *
 * 示例 2：
 *
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 *
 * 示例 3：
 *
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 * 示例 4：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 *
 *
 *
 * 提示：
 *
 *     -231 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/4/11 8:55
 * @modified
 */
public class UglyNumber {

    public boolean isUgly(int n) {
        int cur = n;
        if (cur<1){
            return false;
        }
        while (cur % 2 == 0 || cur % 3 == 0 || cur % 5 ==0 ){
            if (cur % 2 ==0){
                cur = cur / 2;
            }
            if (cur % 3 == 0){
                cur = cur / 3;
            }
            if (cur % 5 == 0){
                cur = cur / 5;
            }
        }
        return cur == 1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        uglyNumber.isUgly(14);
    }
}
