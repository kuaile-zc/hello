package com.zc.leet;

import java.util.*;

/**
 * 1202. 交换字符串中的元素
 *
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 *
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 *
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 10^5
 *     0 <= pairs.length <= 10^5
 *     0 <= pairs[i][0], pairs[i][1] < s.length
 *     s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/11 9:58
 * @modified
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        if (length==1){
            return s;
        }


        Map<Integer, PriorityQueue<Character>> retMap = new HashMap<>();
        //处理pairs (决定使用并查集)
        UnionFind unionFind = new UnionFind(length);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.merge(index1, index2);
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < length ; i++) {
            int root = unionFind.find(i);
            retMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(chars[i]);
        }


        StringBuilder sb = new StringBuilder();
        //取值
        for (int i=0; i<length ; i++){
            sb.append(retMap.get(unionFind.find(i)).poll());
        }

        return sb.toString();
    }

    /**
     * 并查集实现
     */
    private class UnionFind{

        private int[] parent;

        private int[] rank;

        //初始化
        public UnionFind(int n) {
            this.parent =new int[n];
            this.rank =new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int i){
            return parent[i] == i? i : find(parent[i]);
        }

        private void merge(int i, int j){
            int x=find(i), y=find(j);

            if (x==y){
                return;
            }

            if (rank[x]==rank[y]){
                parent[x] = y;
                rank[y]++;
            }else if (rank[x]<rank[y]){
                parent[x] = y;
            }else {
                parent[y] = x;
            }

        }
    }


    public static void main(String[] args) {
        SmallestStringWithSwaps smallestStringWithSwaps = new SmallestStringWithSwaps();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,3));
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(0,2));
        list.add(Arrays.asList(5,6));
        smallestStringWithSwaps.smallestStringWithSwaps("dcabegf", list);
    }
}
