package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 3 * 105
 *     s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 *     s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/10 11:59
 * @modified
 */
public class BasicCalculator {

    public int calculate(String s) {
        s = "(" + s + ")";
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder num = new StringBuilder();
        int index = 0;
        while (index < chars.length) {
            char ch = chars[index];
            int inputNum = Integer.MIN_VALUE;
            if (ch == ')') {
                while (!deque.peek().equals('(')) {
                    int num1 = inputNum == Integer.MIN_VALUE ? getNum(deque) : inputNum;
                    int num2 = getNum(deque);
                    inputNum = num1 + num2;
                }
                deque.poll();
                for (char c : String.valueOf(inputNum).toCharArray()){
                    deque.offerFirst(c);
                }
            } else {
                deque.offerFirst(ch);
            }
            index++;
        }

        return getNum(deque);
    }

    private int getNum(Deque<Character> deque) {
        int ret = 0, multiple = 1;
        while (!deque.isEmpty() && deque.peek() != '(') {
            if (deque.peek() == '-' || deque.peek() == '+'){
                while (!deque.isEmpty() && (deque.peek() == '-' || deque.peek() == '+')){
                    ret = deque.poll() == '-' ? ret*-1 : ret;
                }
                break;
            }

            ret += (deque.poll() - '0') * multiple;
            multiple *= 10;
        }
        return ret;
    }

    private static void arrayTest(int[] arr){
        arr[0] = 1;
    }

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        basicCalculator.calculate("-2+ 1");
        int[] arr = new int[10];
        arrayTest(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
