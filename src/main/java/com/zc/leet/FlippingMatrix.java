package com.zc.leet;

/**
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 20
 *     1 <= A[0].length <= 20
 *     A[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/7 9:57
 * @modified
 */
public class FlippingMatrix {
    public int matrixScore(int[][] A) {
        int rowLength = A.length;
        int lineLength = A[0].length;
        //确定第一列最大都是1
        for (int i=0; i<rowLength; i++){
            if (A[i][0]!=1){
                flipRow(A, i);
            }
        }
        //记录每列1个数（最终结果）
        int[] retArrays = new int[lineLength];
        retArrays[0] = rowLength;
        //然后从第二列开始选定最大值
        for (int i=1; i<lineLength; i++){
            int numb = 0;
            for (int j=0; j<rowLength; j++){
                if (A[j][i]==1){
                    numb++;
                }
            }
            retArrays[i] = Math.max(numb, rowLength-numb);
        }

        int score = 0;
        int baseSecond = 1;
        for (int i=lineLength-1; i>=0; i--){
            score += retArrays[i]*baseSecond;
            baseSecond*=2;
        }
        return score;
    }

    private void flipRow(int[][]A, int row){
        int length = A[0].length;
        for (int i=0; i<length; i++){
            if (A[row][i]==1){
                A[row][i]=0;
            }else {
                A[row][i]=1;
            }
        }
    }

    private void flipLine(int[][]A, int line){
        int length = A.length;
        for (int i=0; i<length; i++){
            if (A[i][line]==1){
                A[i][line]=0;
            }else {
                A[i][line]=1;
            }
        }
    }

    public static void main(String[] args) {
        FlippingMatrix flippingMatrix = new FlippingMatrix();
        flippingMatrix.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}});
    }
}
