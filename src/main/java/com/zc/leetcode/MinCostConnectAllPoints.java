package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 *
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 *
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 *
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 *
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 *
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     1 <= points.length <= 1000
 *     -106 <= xi, yi <= 106
 *     所有点 (xi, yi) 两两不同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/19 14:45
 * @modified
 */
public class MinCostConnectAllPoints {

    int[][] points;

    //尝试使用Kruskal 算法解决最小生成树
    public int minCostConnectPoints(int[][] points) {
        this.points = points;
        int length = points.length;
        if (length==1){
            return 0;
        }

        Union union = new Union(length);
        List<Line> lineList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                lineList.add(new Line(i, j , getLength(i,j) ) );
            }
        }

        Collections.sort(lineList, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.length - o2.length;
            }
        });

        int ret = 0;
        int n = 0;
        for (Line line : lineList){
            if (union.union(line.i, line.j)){
                n++;
                ret += line.length;
            }

            if (n==length-1){
                break;
            }
        }

        return ret;

    }

    private int getLength(int i, int j){
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }

    class Union{
        int[] parent;
        int[] rank;

        public Union(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int i){
            return parent[i] == i ? i : find(parent[i]);
        }

        public boolean union(int x, int y){
            int rootX = find(x), rootY = find(y);

            if (rootX == rootY){
                return false;
            }

            if (rank[rootX] <= rank[rootY]){
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

    class Line{

        private int i;
        private int j;
        private int length;

        public Line(int i, int j, int length) {
            this.i = i;
            this.j = j;
            this.length = length;
        }

    }
}
