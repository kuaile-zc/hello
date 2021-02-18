package com.zc.leetcode;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/01/29/ 17:35
 */
public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = 0;
        //初始化第一行
        for (int i = 1; i < columns; i++) {
            dp[0][i] = Math.max(dp[0][i-1], Math.abs(heights[0][i-1]-heights[0][i]));
        }
        //初始化第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.abs(heights[i-1][0]-heights[i][0]));
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int aboveValue = Math.max(dp[i-1][j], Math.abs(heights[i-1][j]-heights[i][j]));
                int leftValue = Math.max(dp[i][j-1], Math.abs(heights[i][j-1]-heights[i][j]));
                dp[i][j] = Math.min(aboveValue, leftValue);
            }
        }

        return dp[rows-1][columns -1];
    }

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        minimumEffortPath.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}});
    }
}
