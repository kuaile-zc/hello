package com.zc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/01/ 22:59
 */
public class LetterCombinationsOfPhone {

    private static HashMap<Character, String> letterMap = new HashMap<>();

    static {
       letterMap.put('2', "abc");
       letterMap.put('3', "def");
       letterMap.put('4', "ghi");
       letterMap.put('5', "jkl");
       letterMap.put('6', "mno");
       letterMap.put('7', "pqrs");
       letterMap.put('8', "tuv");
       letterMap.put('9', "wxyz");
    }

    private StringBuilder sb = new StringBuilder();
    private int topLayer;
    private List<String> result = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        topLayer = digits.length();
        if (topLayer == 0){
            return result;
        }
        this.digits = digits;
        backtrack(0);
        return result;
    }

    //回溯算法
    private void backtrack(int layer){
        if (layer == topLayer){
            result.add(sb.toString());
            return;
        }
        String pathStr = letterMap.get(digits.charAt(layer));
        for (int i = 0; i < pathStr.length(); i++) {
            sb.append(pathStr.charAt(i));
            backtrack(layer+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhone letterCombinationsOfPhone = new LetterCombinationsOfPhone();
        letterCombinationsOfPhone.letterCombinations("23");
    }
}
