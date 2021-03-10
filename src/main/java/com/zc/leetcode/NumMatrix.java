package com.zc.leetcode;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * <p>
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * <p>
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/3/2 9:44
 * @modified
 */
public class NumMatrix {
    int[][] matrix;

    //自己做的方法   一维前缀和
    public NumMatrix(int[][] matrix,int n) {
        int row = matrix.length;
        if (row==0){
            this.matrix = new int[0][0];
            return;
        }
        int line = matrix[0].length;
        this.matrix = new int[row][line];
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < line; j++) {
                sum += matrix[i][j];
                this.matrix[i][j] = sum;
            }
        }
    }

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        int ret = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                ret += matrix[i][col2];
            } else {
                ret += matrix[i][col2] - matrix[i][col1 - 1];
            }
        }
        return ret;
    }


    int[][] sums;

    //官网方法 二维前缀和
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row==0){
            return;
        }
        int line = matrix[0].length;
        this.sums = new int[row+1][line+1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
