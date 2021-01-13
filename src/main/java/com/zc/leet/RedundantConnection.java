package com.zc.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 684. 冗余连接
 *
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 *
 * 示例 2：
 *
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 *
 * 注意:
 *
 *     输入的二维数组大小在 3 到 1000。
 *     二维数组中的整数在1到N之间，其中N是输入数组的大小。
 *
 * 更新(2017-09-26):
 * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/13 17:04
 * @modified
 */
public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        int index=0;
        Map<Integer, Integer> idMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (!idMap.containsKey(x)){
                idMap.put(x, index++);
            }
            if (!idMap.containsKey(y)){
                idMap.put(y, index++);
            }

            boolean merge = unionFind.merge(idMap.get(x), idMap.get(y));
            if (!merge){
                return edges[i];
            }
        }
        return new int[]{0,0};
    }

    //并查集
    private class UnionFind{

        private int[] parent;

        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            init();
        }

        private void init(){
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i){
            return parent[i] == i ? i : find(parent[i]);
        }

        public boolean merge(int x, int y){
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY){
                return false;
            }

            if (rank[rootX]<=rank[rootY]){
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
            }

            if (rank[rootX] == rank[rootY]){
                rank[rootY]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        redundantConnection.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }
}
