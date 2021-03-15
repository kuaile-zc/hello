package com.zc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * 提示：
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/15 11:10
 * @modified
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, line = matrix[0].length, total = row*line, i=0, j=0;
        List<Integer> ret = new ArrayList<>();
        while (ret.size()<total){
            //向左
            while (j<line && matrix[i][j]!=101) {
                ret.add(matrix[i][j]);
                matrix[i][j] = 101;
                j++;
            }
            j--;
            //向下
            i++;
            while (i<row && matrix[i][j]!=101){
                ret.add(matrix[i][j]);
                matrix[i][j] = 101;
                i++;
            }
            i--;
            //向右
            j--;
            while (j>=0 && matrix[i][j]!=101){
                ret.add(matrix[i][j]);
                matrix[i][j] = 101;
                j--;
            }
            j++;
            //向上
            i--;
            while (i>=0 && matrix[i][j]!=101){
                ret.add(matrix[i][j]);
                matrix[i][j] = 101;
                i--;
            }
            i++;
            j++;
        }

        return ret;

    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
