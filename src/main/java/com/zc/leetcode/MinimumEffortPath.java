package com.zc.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1631. 最小体力消耗路径
 * <p>
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * 示例 3：
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2021/1/30 12:18
 * @modified
 */
public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = 0;
        //初始化第一行
        for (int i = 1; i < columns; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], Math.abs(heights[0][i - 1] - heights[0][i]));
        }
        //初始化第一列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.abs(heights[i - 1][0] - heights[i][0]));
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int aboveValue = Math.max(dp[i - 1][j], Math.abs(heights[i - 1][j] - heights[i][j]));
                int leftValue = Math.max(dp[i][j - 1], Math.abs(heights[i][j - 1] - heights[i][j]));
                dp[i][j] = Math.min(aboveValue, leftValue);
            }
        }

        return dp[rows - 1][columns - 1];
    }

    public int minimumEffortPath2(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        UnionFind unionFind = new UnionFind(rows * columns);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i > 0) {
                    int sub = Math.abs(heights[i - 1][j] - heights[i][j]);
                    int x = (i - 1) * columns + j;
                    int y = i * columns + j;
                    priorityQueue.offer(new int[]{sub, x, y});
                }
                if (j > 0) {
                    int sub = Math.abs(heights[i][j - 1] - heights[i][j]);
                    int x = i * columns + j - 1;
                    int y = i * columns + j;
                    priorityQueue.offer(new int[]{sub, x, y});
                }
            }
        }

        int ret = 0;
        while (!priorityQueue.isEmpty()) {
            int[] data = priorityQueue.poll();
            unionFind.union(data[1], data[2]);
            ret = data[0];
            if (unionFind.findConnect()) {
                break;
            }
        }

        return ret;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return
         */
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            parent[rootX] = rootY;
            return true;
        }

        public boolean findConnect() {
            return find(0) == find(parent.length - 1);
        }
    }

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        minimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}});
        minimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
    }
}
