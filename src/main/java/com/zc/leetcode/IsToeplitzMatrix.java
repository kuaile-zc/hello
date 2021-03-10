package com.zc.leetcode;

/**
 * 766. 托普利茨矩阵
 *
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 *
 *
 *
 * 提示：
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 20
 *     0 <= matrix[i][j] <= 99
 *
 *
 *
 * 进阶：
 *
 *     如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 *     如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/22 10:51
 * @modified
 */
public class IsToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, line = matrix[0].length, index=0;
        if (row==1 || line==1){
            return true;
        }
        int checkNum = (row-1)+(line-1)-1;
        int[][] checkData = new int[checkNum][3];
        //填充第一行需要检验的数字
        for (int i = 0; i < line-1; i++) {
            checkData[index][0] = matrix[0][i];
            checkData[index++][2] = i;
        }
        //填充第一列需要校验的数字
        for (int j = 1; j < row - 1; j++) {
            checkData[index][0] = matrix[j][0];
            checkData[index++][1] = j;
        }

        for (int i = 0; i < checkNum; i++) {
            int value = checkData[i][0];
            int x = checkData[i][1] + 1;
            int y = checkData[i][2] + 1;
            while (x<row && y<line){
                if (matrix[x++][y++]!=value){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsToeplitzMatrix isToeplitzMatrix = new IsToeplitzMatrix();
        isToeplitzMatrix.isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}});
    }
}
