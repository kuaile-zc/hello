package com.zc.leetcode;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 *     一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 *     一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 *     你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 *
 * 提示：
 *
 *     m == matrix.length
 *     n == matrix[0].length
 *     1 <= m, n <= 200
 *     -231 <= matrix[i][j] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/03/21/ 10:45
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length, line = matrix[0].length, rowTop = -1;
        for (int i = 0; i < row; i++) {
            boolean hasZero = false;
            for (int j = 0; j < line; j++) {
                if (matrix[i][j]==0){
                    hasZero = true;
                    break;
                }
            }
            if (hasZero){
                rowTop = rowTop == -1 ? i : rowTop;
                for (int j = 0; j < line; j++) {
                    if (matrix[i][j]==0){
                        matrix[rowTop][j]=-1;
                    }else {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //将竖条归零
        for (int j = 0; j < line && rowTop!=-1; j++) {
            if (matrix[rowTop][j]==-1){
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(new int[][]{{1}});
    }
}
