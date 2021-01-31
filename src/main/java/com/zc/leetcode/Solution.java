package com.zc.leetcode;

/**
 * 此类用于演示动态规划案例 LeetCode.62
 * @author CoreyChen Zhang
 * @version 2020/10/22 19:24
 * @modified
 */
public class Solution {
    // 有一个m X n 的方格 m列   n是行
    public int uniquePaths(int m, int n) {
        //创建结果集
        int[][] ret = new int[n][m];
        //初始化
        ret[0][0] = 1;
        //初始化第一列
        for (int j = 0; j<m; j++){
            ret[0][j] = 1;
        }
        //初始化第一竖行
        for (int i=0; i<n ; i++){
            ret[i][0] = 1;
        }

        //遍历每行
        for (int i = 1; i<n; i++){
            //遍历每列
            for (int j = 1; j<m; j++){
                //F(i,j)  =  F(i-1,j)  +  F(i,j-1)
                ret[i][j] = ret[i-1][j] + ret[i][j-1];
            }
        }

        return ret[n-1][m-1];
    }
}
