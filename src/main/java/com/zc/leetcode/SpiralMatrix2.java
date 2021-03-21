package com.zc.leetcode;

/**
 * 59. 螺旋矩阵 II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/16 10:24
 * @modified
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int total = n*n, i= 0, j=0 ,k=1;
        while (k<=total) {
            //向左
            while (j<n && ret[i][j]==0){
                ret[i][j] = k++;
                j++;
            }
            j--;
            i++;
            //向下
            while (i<n && ret[i][j]==0){
                ret[i][j] = k++;
                i++;
            }
            i--;
            j--;
            //向左
            while (j>=0 && ret[i][j]==0){
                ret[i][j] = k++;
                j--;
            }
            j++;
            i--;
            while (i>=0 && ret[i][j]==0){
                ret[i][j] = k++;
                i--;
            }
            i++;
            j++;
        }
        return ret;
    }



    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        spiralMatrix2.generateMatrix2(5);
    }
}
