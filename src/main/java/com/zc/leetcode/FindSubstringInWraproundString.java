package com.zc.leetcode;

import java.util.Arrays;

/**
 * @author corey
 * @creat 2022/5/25 22:54
 * @describe https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
public class FindSubstringInWraproundString {

    public static void main(String[] args) {
        
    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i>0 && (p.charAt(i) - p.charAt(i-1) + 26 )%26 == 1) {
                k++;
            }else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(k, dp[p.charAt(i) - 'a']);
        }
        return Arrays.stream(dp).sum();
    }

    
}
