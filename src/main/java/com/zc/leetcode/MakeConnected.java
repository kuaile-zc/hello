package com.zc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1319. 连通网络的操作次数
 *
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * 示例 2：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 *
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 10^5
 *     1 <= connections.length <= min(n*(n-1)/2, 10^5)
 *     connections[i].length == 2
 *     0 <= connections[i][0], connections[i][1] < n
 *     connections[i][0] != connections[i][1]
 *     没有重复的连接。
 *     两台计算机不会通过多条线缆连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/01/23/ 22:15
 */
public class MakeConnected {

    public int makeConnected(int n, int[][] connections) {
        int length = connections.length;
        if (length<n-1){
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < length; i++) {
            int x = connections[i][0];
            int y = connections[i][1];
            unionFind.merge(x,y);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int k = unionFind.find(i);
            if (!set.contains(k)){
                set.add(k);
            }
        }
        return set.size() -1;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * 压缩
         * @return
         */
        public int find(int i){
            return parent[i] == i ? i : find(parent[i]);
        }

        public void merge(int x, int y){
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY){
                return;
            }

            if (rank[rootX]<=rank[rootY]){
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
            }

            if (rank[rootX]==rank[rootY]){
                rank[rootY]++;
            }
        }
    }

    public static void main(String[] args) {
        MakeConnected makeConnected = new MakeConnected();
        makeConnected.makeConnected(4, new int[][]{{0,1},{0,2},{1,2}});
    }
}
