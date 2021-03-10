package com.zc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/8 10:11
 * @modified
 */
public class PalindromePartitioning2 {

    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        if (length<2){
            return 0;
        }
        //dp[left][right] 表示当前区间字符是否是回文字符串
        boolean[][] dp = new boolean[length][length];
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (chars[left]==chars[right] && (right-left<=2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }

        //retDp[i]表示以i结尾的最短
        int[] retDp = new int[length];
        retDp[0] = 1;
        for (int i = 1; i < length; i++) {
            retDp[i] = Integer.MAX_VALUE;
            for (int j = -1; j < i; j++) {
                int right = i;
                int left = j+1;
                if (dp[left][right]){
                    retDp[i] = Math.min(retDp[i], (j==-1? 0 : retDp[j])+1);
                }
            }
        }
        return retDp[length-1] -1;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2();
        palindromePartitioning2.minCut("aab");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        Vector<Integer> vector = new Vector<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a","a");
        hashSet.add(1);
        hashSet.contains(1);
        hashSet.iterator();
        tableSizeFor(6);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.iterator();
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return  n + 1;
    }
}
