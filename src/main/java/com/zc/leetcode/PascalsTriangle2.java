package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/12 9:44
 * @modified
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex ; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if (j==0 || j==i){
                    cur.add(1);
                }else {
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
        pascalsTriangle2.getRow(5);
    }
}
