package com.zc.leetcode;

/**
 * @author corey
 * @creat 2022/5/28 12:27
 * @describe TODO
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        removeOuterParentheses.removeOuterParentheses("(()())(())");
    }

    final private static char LEFT_BRACKET = '(';
    final private static char RIGHT_BRACKET = ')';
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int curBracketNum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case LEFT_BRACKET:
                    if (curBracketNum > 0) {
                        result.append(s.charAt(i));
                    }
                    curBracketNum++;
                    break;
                case RIGHT_BRACKET:
                    if (curBracketNum > 1) {
                        result.append(s.charAt(i));
                    }
                    curBracketNum--;
                    break;
            }
        }
        return result.toString();
    }
}
