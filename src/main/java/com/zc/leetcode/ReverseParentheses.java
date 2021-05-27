package com.zc.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @date 2021/5/26 10:02
 * @modified
 */
public class ReverseParentheses {

    private final static Character POSITIVE_BRACKET = '(';
    private final static Character NEGATIVE_BRACKET = ')';

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseParentheses reverseParentheses = new ReverseParentheses();
        reverseParentheses.reverseParentheses("(u(love)i)");
    }
}
