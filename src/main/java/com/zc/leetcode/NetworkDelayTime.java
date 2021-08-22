package com.zc.leetcode;

import java.util.Map;

/**
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 *
 *
 *
 * 提示：
 *
 *     1 <= k <= n <= 100
 *     1 <= times.length <= 6000
 *     times[i].length == 3
 *     1 <= ui, vi <= n
 *     ui != vi
 *     0 <= wi <= 100
 *     所有 (ui, vi) 对都 互不相同（即，不含重复边）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/08/02/ 21:34
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        UnitCollection unitCollection = new UnitCollection(n+1);
        for (int i = 0; i < times.length; i++) {
            unitCollection.add(times[i][0], times[i][1], times[i][2]);
        }
        return unitCollection.times(n,k);
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        networkDelayTime.networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2);
    }

    //并查集
    class UnitCollection{

        private int[] parent;
        private int[] counts;

        public UnitCollection(int n) {
            this.parent = new int[n];
            this.counts = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void add(int a, int b, int count) {
            int root = getParent(a);
            parent[b] = root;
            counts[b] = count + counts[a];
        }

        private int getParent(int a) {
            if (parent[a] != a) {
                parent[a] = getParent(parent[a]);
            }
            return parent[a];
        }

        public int times(int k, int n) {
            int max = 0;
            for (int i = 1; i <= n; i++) {
                int distance = distance(k, i);
                if (distance == -1){
                    return -1;
                }
                max = Math.max(max, distance);
            }

            return max;
        }

        private int distance(int a, int b) {
            if (parent[a] != parent[b]) {
                return  -1;
            }
            return Math.abs(counts[a]-counts[b]);
        }
    }
}
