package com.zc.leetcode;

/**
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 *     "AAJF" ，将消息分组为 (1 1 10 6)
 *     "KJF" ，将消息分组为 (11 10 6)
 *
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 * 示例 4：
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 100
 *     s 只包含数字，并且可能包含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author CoreyChen Zhang
 * @Date: 2021/04/22/ 9:48
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int length = s.length();
        //d[i][0-1]表示第i个0表示单独作为一个1表示和前一个组合
        int[][] dp = new int[length][2];
        if (Integer.valueOf(s.charAt(0)-'0') != 0){
            dp[0][0] = 1;
        }

        for (int i = 1; i < length; i++) {
            int single = Integer.valueOf(s.charAt(i)-'0');
            int preSingle = Integer.valueOf(s.charAt(i-1)-'0');
            //赋值单体不拼接
            if (single != 0){
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
            }
            //赋值带前一个的合并数字
            if (preSingle != 0){
                Integer doubleInt = Integer.valueOf(s.substring(i - 1, i + 1));
                if (doubleInt > 0 && doubleInt <= 26){
                    dp[i][1] = dp[i-1][0];
                }
            }

        }
        return dp[length-1][0] + dp[length-1][1];

    }
}
