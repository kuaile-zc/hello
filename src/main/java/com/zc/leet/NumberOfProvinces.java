package com.zc.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 *
 * 示例 1：
 *   1-->2
 *     3
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 *
 * 示例 2：
 *
 *   1   2
 *     3
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 200
 *     n == isConnected.length
 *     n == isConnected[i].length
 *     isConnected[i][j] 为 1 或 0
 *     isConnected[i][i] == 1
 *     isConnected[i][j] == isConnected[j][i]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2021-01-07 21:56
 */
public class NumberOfProvinces {
    int[] fa, rank;

    //并查集解决 （按秩）
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        fa = new int[length];
        rank = new int[length];
        init();
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j]==1){
                    merge(i,j);
                }
            }
        }

        int ret = 0;
        for (int i=0; i<length; i++){
            if (find(i) == i){
                ret++;
            }
        }

        return ret;

    }

    //初始化
    private void init(){
        int length = fa.length;
        for (int i = 0; i < length; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    //查找
    private int find(int i){
        return fa[i] == i ? i : find(fa[i]);
    }

    //合并
    private void merge(int i, int j){
        int x=find(i), y=find(j);

        if (x==y){
            return;
        }

        if (rank[x]<=rank[y]){
            fa[x] = y;
        }else {
            fa[y] = x;
        }

        if (rank[x]==rank[y] && x!=y){
            rank[y]++;
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        numberOfProvinces.findCircleNum(isConnected);
    }
}
