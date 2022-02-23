package com.zc.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 688. 骑士在棋盘上的概率
 *
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 *
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 *
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 *
 *
 *
 * 提示:
 *
 *     1 <= n <= 25
 *     0 <= k <= 100
 *     0 <= row, column <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2022/2/17 17:35
 * @modified
 */
public class KnightProbability {

    private int[][] MOVE_ARRAYS = new int[][]{{-2,-1}, {-2,1}, {2,-1}, {2,1}, {-1,-2}, {1,-2}, {-1,2}, {1,2}};

    //超出时间限制
    public double knightProbability(int n, int k, int row, int column) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, column});
        for (int i = 0; i < k; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] poll = queue.pollLast();
                for (int[] move : MOVE_ARRAYS) {
                    int curRow = poll[0] + move[0], curCol = poll[1] + move[1];
                    if (curRow >= 0 && curRow < n && curCol >= 0 && curCol < n) {
                        queue.addFirst(new int[]{curRow, curCol});
                    }
                }
            }
        }
        return queue.size() / Math.pow(8, k);
    }

    //动态规划dp[step][i][j]表示骑士从棋盘上的点 (i,j)(i, j)(i,j) 出发，走了 step 步时仍然留在棋盘上的概率
    public double knightProbability2(int n, int k, int row, int column) {
        double[][][] result = new double[k+1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        result[step][i][j] = 1;
                    }else {
                        for (int[] move : MOVE_ARRAYS) {
                            int curRow = move[0] + i, curCol = move[1] + j;
                            if (curRow >= 0 && curRow < n && curCol >= 0 && curCol < n) {
                                result[step][i][j] += result[step-1][curRow][curCol]/8;
                            }
                        }
                    }
                }
            }
        }
        return result[k][row][column];
    }

    public static void main(String[] args) {
        KnightProbability knightProbability = new KnightProbability();
        knightProbability.knightProbability(3,2,0,0);
    }
}
