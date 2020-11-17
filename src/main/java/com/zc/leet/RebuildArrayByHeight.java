package com.zc.leet;

import java.util.*;

/**
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 *
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 *
 * 示例：
 *
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 *
 * 提示：
 *
 *     总人数少于 1100 人。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/16 14:19
 * @modified
 */
public class RebuildArrayByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2)-> o1[0]==o2[0]? o1[1]-o2[1] : o2[0]-o1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] i: people){
            list.add(i[1],i);
        }
        return list.toArray(people);
    }


    public static void main(String[] args) {
        RebuildArrayByHeight rebuildArrayByHeight = new RebuildArrayByHeight();
        int[][] input =new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        rebuildArrayByHeight.reconstructQueue(input);
    }

}
