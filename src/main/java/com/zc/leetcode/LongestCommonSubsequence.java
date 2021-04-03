package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 *     例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 *
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 *
 * 提示：
 *
 *     1 <= text1.length, text2.length <= 1000
 *     text1 和 text2 仅由小写英文字符组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/4/3 16:33
 * @modified
 */
public class LongestCommonSubsequence {

    //回溯算法超时
    public int longestCommonSubsequence(String text1, String text2) {
        Set<String> result1 = new HashSet<>();
        backtrack(text1, result1, new StringBuilder(), 0);
        System.out.println(result1);

        Set<String> result2 = new HashSet<>();
        backtrack(text2, result2, new StringBuilder(), 0);
        System.out.println(result2);

        result1.retainAll(result2);
        return result1.stream().map(String::length).max(Integer::compare).get();

    }

    private void backtrack(String str, Set<String> result, StringBuilder stringBuilder, int index){
        if (index > str.length()){
            return;
        }else {
            System.out.println(stringBuilder.toString());
            result.add(stringBuilder.toString());
        }

        for (int i = index; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            backtrack(str, result, stringBuilder, i+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    //动态规划
    public int longestCommonSubsequence2(String text1, String text2) {
        int length1 = text1.length(), length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i <= length1; i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                if (c == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        longestCommonSubsequence.longestCommonSubsequence2("ace", "abcde");
    }
}
