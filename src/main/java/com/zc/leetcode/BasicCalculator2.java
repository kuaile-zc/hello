package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/3/11 14:00
 * @modified
 */
public class BasicCalculator2 {

    public int calculate(String s) {
        s = s.replace(" ", "");
        int length = s.length(), ret = 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '/' || ch == '*') {
                int num1 = getValue(deque);
                char symbol = ch;
                int start = ++i;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                int num2 = Integer.valueOf(s.substring(start, i--));
                int result = 0;
                switch (symbol) {
                    case '/':
                        result = num1 / num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                }
                deque.addFirst('+');
                for (char c : String.valueOf(result).toCharArray()) {
                    deque.addFirst(c);
                }
            } else {
                deque.addFirst(ch);
            }
        }

        while (!deque.isEmpty()) {
            ret += getValue(deque);
        }
        return ret;
    }

    private int getValue(ArrayDeque<Character> deque) {
        int ret = 0, multiple = 1;
        while (!deque.isEmpty() && deque.peek() >= '0' && deque.peek() <= '9') {
            ret += (deque.poll() - '0') * multiple;
            multiple *= 10;
        }
        while (!deque.isEmpty() && (deque.peek() == '-' || deque.peek() == '+')) {
            int sym = deque.poll() == '-' ? -1 : 1;
            ret = ret * sym;
        }
        return ret;
    }




    public static void main(String[] args) {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        basicCalculator2.calculate("2*3+4");
    }
}
