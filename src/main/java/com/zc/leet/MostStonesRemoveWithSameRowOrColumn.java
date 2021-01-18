package com.zc.leet;

import java.util.*;

/**
 * 947. 移除最多的同行或同列石头
 *
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 *
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 *
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 *
 *
 *
 * 提示：
 *
 *     1 <= stones.length <= 1000
 *     0 <= xi, yi <= 104
 *     不会有两块石头放在同一个坐标点上
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/15 16:20
 * @modified
 */
public class MostStonesRemoveWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones){
            unionFind.union(stone[0]+10000, stone[1]);
        }

        return stones.length-unionFind.getCount();
    }

    class UnionFind{
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> rank;
        private int count =0;

        public UnionFind() {
            parent = new HashMap<>();
            rank = new HashMap<>();
        }

        private int find(int i){
            if (!parent.containsKey(i)){
                parent.put(i,i);
                rank.put(i,1);
                count++;
            }

            return parent.get(i) == i ? i : find(parent.get(i));
        }

        public void union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if (rootX==rootY){
                return;
            }

            if ((int)rank.get(rootX)<=(int)rank.get(rootY)){
                parent.put(rootX, rootY);
            }else {
                parent.put(rootY, rootX);
            }

            if (rank.get(rootX).equals(rank.get(rootY))){
                rank.put(rootY, rank.get(rootY)+1);
            }

            count--;
        }

        public int getCount(){
            return count;
        }
    }

    public static void main(String[] args) {
        MostStonesRemoveWithSameRowOrColumn mostStonesRemoveWithSameRowOrColumn = new MostStonesRemoveWithSameRowOrColumn();
        mostStonesRemoveWithSameRowOrColumn.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}});
    }
}
