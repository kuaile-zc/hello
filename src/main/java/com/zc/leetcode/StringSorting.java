package com.zc.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author CoreyChen Zhang
 * @date 2021/6/22 15:55
 * @modified
 */
public class StringSorting {

    char[] chars;
    Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        chars = s.toCharArray();
        recall(0, chars.length-1);
        return result.toArray(new String[result.size()]);
    }

    //回溯
    private void recall(int low, int high){
        if (low == high){
            result.add(String.valueOf(chars));
            return;
        }

        for (int i = low; i <= high; i++) {
            boolean succeed = switchStr(low, i);
            if (!succeed){
                continue;
            }
            recall(low+1, high);
            switchStr(low, i);
        }
    }

    private boolean switchStr(int i, int j){
        if (i == j){
            return true;
        }
        if (chars[i] == chars[j]){
            return false;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return true;
    }

    public static void main(String[] args) {
        StringSorting stringSorting = new StringSorting();
        stringSorting.permutation("acc");
    }
}
