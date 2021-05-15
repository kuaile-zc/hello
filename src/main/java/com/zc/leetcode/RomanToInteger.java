package com.zc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * @Author CoreyChen Zhang
 * @Date: 2021/05/15/ 13:29
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (i != length-1 && map.get(s.charAt(i+1)) > map.get(c)){
                result -= map.get(c);
            }else {
                result += map.get(c);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        romanToInteger.romanToInt("IV");
    }
}
