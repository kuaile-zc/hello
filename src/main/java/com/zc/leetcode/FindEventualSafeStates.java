package com.zc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 802. 找到最终的安全状态
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 *
 *
 * 示例 1：
 * Illustration of graph
 *
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 *
 * 示例 2：
 *
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 *
 *
 *
 * 提示：
 *
 *     n == graph.length
 *     1 <= n <= 104
 *     0 <= graph[i].length <= n
 *     graph[i] 按严格递增顺序排列。
 *     图中可能包含自环。
 *     图中边的数目在范围 [1, 4 * 104] 内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/8/5 14:22
 * @modified
 */
public class FindEventualSafeStates {

    int[][] graph;
    boolean[] isFinish;
    int curIndex = 0;

    //超时
    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        int length = graph.length;
        List<Integer> result = new ArrayList<>();
        isFinish = new boolean[length];

        for (int i = 0; i < length; i++) {
            curIndex = i;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            if (isFinish[i] = dfs(graph[i], list)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[] paths, List<Integer> list) {
        for (int path: paths) {
            if (list.contains(path) || (path < curIndex && !isFinish[path])) {
                return false;
            }
            list.add(path);
            if (!dfs(graph[path], list)) {
                return false;
            }
            list.remove(list.size()-1);
        }
        return true;
    }

    //官网答案，三色标记法
    //白色（用 0 表示）：该节点尚未被访问；
    //灰色（用 1 表示）：该节点位于递归栈中，或者在某个环上；
    //黑色（用 2 表示）：该节点搜索完毕，是一个安全节点。
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (isSafe(graph, color, i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSafe(int[][] graph, int[] color, int x) {
        if (color[x] > 0){
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!isSafe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }


    public static void main(String[] args) {
        FindEventualSafeStates findEventualSafeStates = new FindEventualSafeStates();
        findEventualSafeStates.eventualSafeNodes2(new int[][]{{1,2}, {2,3}, {5}, {0}, {5}, {}, {}});
    }
}
