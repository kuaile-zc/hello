package com.zc.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 返回区域的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   " /",
 *   "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   " /",
 *   "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 *
 * 示例 4：
 *
 * 输入：
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 *
 * 示例 5：
 *
 * 输入：
 * [
 *   "//",
 *   "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 *
 *
 *
 * 提示：
 *
 *     1 <= grid.length == grid[0].length <= 30
 *     grid[i][j] 是 '/'、'\'、或 ' '。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/25 10:52
 * @modified
 */
public class RegionsCutBySlashes {

    /**
     *          a
     *        d × b
     *          c
     *    按照上面划分网格
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        //将一个1*1 的小方格分为四个部分
        int n = 4* length*length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < length; i++) {
            String str = grid[i];
            for (int j = 0; j < length; j++) {
                char ch = str.charAt(j);
                int index = 4*(i*length + j);
                int a = index;
                int b = index + 1;
                int c = index + 2;
                int d = index + 3;
                if (ch==' '){
                    unionFind.union(a,b);
                    unionFind.union(a,c);
                    unionFind.union(a,d);
                }else if (ch=='/'){
                    unionFind.union(a, d);
                    unionFind.union(b, c);
                }else if (ch=='\\'){
                    unionFind.union(a,b);
                    unionFind.union(c,d);
                }
                //当前格子a与上层c是连接的
                if (i>0){
                    unionFind.union(a, 4*((i-1)*length + j) + 2 );
                }
                //当前格子d与左边格子b连接的
                if (j>0){
                    unionFind.union(d, 4*(i*length + j -1) + 1 );
                }
            }
        }

        return unionFind.getCount();


    }

    class UnionFind{
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i){
            if (parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            count--;
        }

        public int getCount() {
            return count;
        }
    }

}
