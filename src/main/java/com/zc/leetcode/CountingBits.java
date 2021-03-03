package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/3 10:19
 * @modified
 */
public class CountingBits {

    //位运算遍历
    public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for(int i=0; i<=num; i++){
            int count=0, k = i;
            while(k>0){
               k &= (k-1);
               count++;
            }
            ret[i] = count;
        }

        return ret;
    }

    //动态规划
    public int[] countBits2(int num) {
        int[] ret = new int[num+1];
        int highBinary = 0;
        for(int i=1; i<=num; i++){
            if ((i&(i-1))==0){
                highBinary = i;
            }
            ret[i] = ret[i-highBinary] + 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        countingBits.countBits(10);
    }

}
