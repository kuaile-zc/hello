package com.zc.leetcode;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/20/ 9:34
 */
public class MyStrMethod {

    public int strStr(String haystack, String needle) {
        int targetLength = haystack.length(), findLength = needle.length();
        if (findLength == 0){
            return 0;
        }

        for (int i = 0; i < targetLength; i++) {
            final int retainLength = targetLength - i;
            if (haystack.charAt(i) == needle.charAt(0) && retainLength >= findLength){
                final String subHaystack = haystack.substring(i, i+findLength);
                if (subHaystack.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
