package com.zc.leetcode;

import java.util.LinkedList;

/**
 *
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/5/3 6:45
 * @modified
 */
public class ReverseInteger {

    public int reverse(int x) {

        LinkedList<Integer> stack = new LinkedList<>();
        int digit = 0, copyX = x, result = 0;
        while (copyX != 0){
            if (result < Integer.MIN_VALUE/10 || result > Integer.MAX_VALUE/10){
                return 0;
            }
            digit = copyX % 10;
            copyX /= 10;
            result = result*10 + digit;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        reverseInteger.reverse(-123);
    }
}
