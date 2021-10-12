package com.zc.leetcode;

import io.netty.handler.codec.string.LineSeparator;

import java.util.ArrayList;
import java.util.List;

/**
 * 352. 将数据流变为多个不相交区间
 * 给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 *     SummaryRanges() 使用一个空数据流初始化对象。
 *     void addNum(int val) 向数据流中加入整数 val 。
 *     int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
 * [[], [1], [], [3], [], [7], [], [2], [], [6], []]
 * 输出：
 * [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
 *
 * 解释：
 * SummaryRanges summaryRanges = new SummaryRanges();
 * summaryRanges.addNum(1);      // arr = [1]
 * summaryRanges.getIntervals(); // 返回 [[1, 1]]
 * summaryRanges.addNum(3);      // arr = [1, 3]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
 * summaryRanges.addNum(7);      // arr = [1, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
 * summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
 * summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
 * summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 *
 *
 *
 * 提示：
 *
 *     0 <= val <= 104
 *     最多调用 addNum 和 getIntervals 方法 3 * 104 次
 *
 *
 *
 * 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/10/9 10:20
 * @modified
 */
public class DataStreamIntervals {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();

    }


    static class SummaryRanges {

        private List<Integer> data;

        public SummaryRanges() {
            data = new ArrayList<>();
        }

        public void addNum(int val) {
            int length = data.size();
            if (length == 0) {
                data.add(val);
            }
            for (int i = 0; i < length; i++) {
                if (val < data.get(i)) {
                    data.add(i, val);
                }
            }
        }

        public int[][] getIntervals() {
            List<int[]> result = new ArrayList<>();
            int length = data.size();
            if (length == 0) {
                return new int[][]{};
            }
            int index = 0;
            while (index < length) {
                int[] section = new int[]{data.get(index), data.get(index)};
                while (index < length - 1 && data.get(index+1) - data.get(index) == 1) {
                    index++;
                }
                result.add(section);
            }
            int[][] resultArrays = new int[result.size()][2];
            for (int i = 0; i < result.size(); i++) {
                resultArrays[i] = result.get(i);
            }
            return resultArrays;
        }
    }

}


