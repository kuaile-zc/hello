package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
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
