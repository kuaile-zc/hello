package com.zc.leetcode;

/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：6
 *
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     0 <= n <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/8/13 14:04
 * @modified
 */
public class CountDigitOne {

    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int num = 0, temp = i;
            while (temp != 0) {
                if (temp%10 == 1) {
                    num++;
                }
                temp /= 10;
            }
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        countDigitOne.countDigitOne(11);
    }

}
