package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 通过次数77,725
 * 提交次数108,049
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/7 16:41
 * @modified
 */
public class PalindromePartitioning {

    private List<List<String>> ret;
    private byte[] bytes;
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        bytes = s.getBytes();
        int length = s.length();
        ret = new ArrayList<>();
        //记忆回溯
        dp = new boolean[length][length];
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (bytes[right] == bytes[left] && (right-left<=2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }
        backtrack(0, new ArrayDeque<>());
        return ret;
    }

    public void backtrack(int index, Deque<String> path){
        if (index == bytes.length){
            ret.add(new ArrayList<String>(path));
            return;
        }

        for (int i = index; i < bytes.length; i++) {
            if (dp[index][i]){
                path.offerLast(new String(bytes, index, i-index+1));
                backtrack(i+1, path);
                path.pollLast();
            }
        }
    }

    private boolean isPalindrome(int index, int end){
        System.out.println(index+"--"+end);
        int left = index, right = end;
        while (left<=right){
            if (bytes[left++]!=bytes[right--]){
                return false;
            }
        }
        dp[index][end] = true;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition("aab");

    }

    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        threadLocal.get();
    }
}
