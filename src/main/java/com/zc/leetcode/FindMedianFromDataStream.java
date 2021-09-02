package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 *     void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *     double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 *
 *     如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 *     如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/8/27 13:57
 * @modified
 */
public class FindMedianFromDataStream {

    static class MedianFinder {

        List<Integer> data;

        /** initialize your data structure here. */
        public MedianFinder() {
           data = new ArrayList<>();
        }

        public void addNum(int num) {
            int length = data.size();
            if (data.size() == 1) {
                data.add(num);
                Collections.sort(data);
                return;
            }
            int left = 0, right = length-1;
            while (left <= right) {
                int half =left + (right - left)/2;
                if (data.get(half) < num) {
                    left = half + 1;
                }else {
                    right = half - 1;
                }
            }
            data.add(left, num);
        }

        public double findMedian() {
            if (data.size()%2 == 0) {
                return (double) (data.get(data.size()/2 - 1) + data.get(data.size()/2) )/2;
            }else {
                return data.get(data.size()/2);
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
