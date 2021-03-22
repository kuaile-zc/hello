package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/22 18:02
 * @modified
 */
public class NumberOfOneBits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int base = 1, ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((base | n) == n){
                ret++;
            }
            base = base << 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        numberOfOneBits.hammingWeight(11);
        Integer.bitCount(11);
    }
}
