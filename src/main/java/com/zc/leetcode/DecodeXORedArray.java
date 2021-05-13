package com.zc.leetcode;

import java.util.Optional;

/**
 * 1720. 解码异或后的数组
 * @author CoreyChen Zhang
 * @date 2021/5/6 11:32
 * @modified
 */
public class DecodeXORedArray {

    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] result = new int[length+1];
        result[0] = first;
        for (int i = 1; i <= length; i++) {
            result[i] = encoded[i-1] ^ result[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        Optional<String> s = Optional.of(String.valueOf(null));
        System.out.println("");

    }
}
