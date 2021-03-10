package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @version 2021/2/18 20:34
 * @modified
 */
public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, line = nums[0].length;
        if (r*c != row*line){
            return nums;
        }
        int[][] ret = new int[r][c];
        int rowIndex=0, lineIndex=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line ;j++) {
                int temp = nums[i][j];
                ret[rowIndex][lineIndex] = temp;
                if (lineIndex < c-1){
                    lineIndex++;
                }else {
                    lineIndex =0;
                    rowIndex++;
                }
            }
        }
        return ret;
    }
}
