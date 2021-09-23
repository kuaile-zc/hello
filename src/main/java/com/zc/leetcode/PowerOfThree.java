package com.zc.leetcode;

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 *
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     -231 <= n <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/9/23 10:00
 * @modified
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        int copyN = n;
        while (copyN > 1) {
            int temp = copyN/3;
            if (temp*3 != copyN) {
                return false;
            }
            copyN = temp;
        }
        return true;
    }
}
