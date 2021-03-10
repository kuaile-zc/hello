package com.zc.leetcode;

/**
 * 803. 打砖块
 *
 * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
 *
 *     一块砖直接连接到网格的顶部，或者
 *     至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
 *
 * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
 *
 * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
 *
 * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
 * 输出：[2]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0]，
 *  [1,1,1,0]]
 * 消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0]
 *  [0,1,1,0]]
 * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
 * [[1,0,0,0],
 *  [0,0,0,0]]
 * 因此，结果为 [2] 。
 *
 * 示例 2：
 *
 * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
 * 输出：[0,0]
 * 解释：
 * 网格开始为：
 * [[1,0,0,0],
 *  [1,1,0,0]]
 * 消除 (1,1) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 *  [1,0,0,0]]
 * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
 * [[1,0,0,0],
 *  [1,0,0,0]]
 * 接下来消除 (1,0) 处加粗的砖块，得到网格：
 * [[1,0,0,0],
 *  [0,0,0,0]]
 * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
 * 因此，结果为 [0,0] 。
 *
 *
 *
 * 提示：
 *
 *     m == grid.length
 *     n == grid[i].length
 *     1 <= m, n <= 200
 *     grid[i][j] 为 0 或 1
 *     1 <= hits.length <= 4 * 104
 *     hits[i].length == 2
 *     0 <= xi <= m - 1
 *     0 <= yi <= n - 1
 *     所有 (xi, yi) 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/01/17/ 18:04
 */
public class BricksFallingWhenHit {

    private int row;
    private int line;

    private static final int[][] DISTANCE = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        row = grid.length;
        line = grid[0].length;

        int size = row*line;
        UnionFind unionFind = new UnionFind(size + 1);

        //复制源数据
        int[][] copy = new int[row][line];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        //使用逆向思维先敲掉已经存在的砖块
        for (int i = 0; i < hits.length; i++) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (copy[x][y] == 1){
                copy[x][y] =0;
            }
        }

        //将第一行都归到根节点
        for (int i = 0; i < line; i++) {
            if (copy[0][i]==1){
                unionFind.union(size, i);
            }
        }

        //拼接所有砖块
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (copy[i][j]==1){
                    if (copy[i-1][j]==1){
                        unionFind.union(getSiteByCoordinate(i-1,j), getSiteByCoordinate(i,j));
                    }
                    if (j-1>=0 && copy[i][j-1]==1){
                        unionFind.union(getSiteByCoordinate(i,j-1), getSiteByCoordinate(i,j));
                    }
                }
            }
        }

        int[] ret = new int[hits.length];

        for (int i = hits.length-1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y]==0){
                continue;
            }

            //得到当前根节点的子节点数量
            int beforeSize = unionFind.getSize(size);

            if (x==0){
                unionFind.union(size, y);
            }
            //上下左右合并
            for (int[] distance : DISTANCE){
                int distanceX = distance[0] + x;
                int distanceY = distance[1] + y;
                if (isArea(distanceX, distanceY) && copy[distanceX][distanceY] == 1){
                    unionFind.union(getSiteByCoordinate(distanceX, distanceY), getSiteByCoordinate(x,y));
                }
            }

            //得到加完之后根节点的子节点数量
            int currentSize = unionFind.getSize(size);

            ret[i] = currentSize-beforeSize == 0 ? 0 : (currentSize - beforeSize -1);
            copy[x][y] = 1;
        }

        return ret;
    }

    private int getSiteByCoordinate(int x, int y){
        return x*line + y;
    }

    private boolean isArea(int x, int y){
        return  (x>=0 && x<row) && (y>=0 && y<line);
    }

    class UnionFind{
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int getSize(int i){
            return size[find(i)];
        }

        /**
         * 路径压缩
         * @param i
         * @return
         */
        public int find(int i){
            if (parent[i]!=i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        /**
         * 将y节点放到x上
         * @param x
         * @param y
         */
        public void union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if (rootX==rootY){
                return;
            }

            parent[rootY] = rootX;
            size[rootX]+= size[rootY];
        }

    }

    public static void main(String[] args) {
        BricksFallingWhenHit bricksFallingWhenHit = new BricksFallingWhenHit();
        bricksFallingWhenHit.hitBricks(new int[][]{{1,0,0,0},{1,1,1,0}}, new int[][]{{1,0}});
    }

}
