package com.zc.leetcode;

import java.util.HashMap;

/**
 * 476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 *
 * 提示：
 *
 *     给定的整数 num 保证在 32 位带符号整数的范围内。
 *     num >= 1
 *     你可以假定二进制数不包含前导零位。
 *     本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/10/18 9:28
 * @modified
 */
public class NumberComplement {

    public int findComplement(int num) {
        int max = 1, copyNum = num;
        while (copyNum != 1) {
            copyNum = copyNum >> 1;
            max = (max << 1) +1;
        }
        return max - num;
    }

    public static void main(String[] args) {
        System.out.println(Character.toString((char) 2));
        System.out.println(Character.toString((char) 1));
        NumberComplement numberComplement = new NumberComplement();
        numberComplement.findComplement(5);
    }
}
