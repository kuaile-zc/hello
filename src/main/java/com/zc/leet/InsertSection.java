package com.zc.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/4 10:19
 * @modified
 */
public class InsertSection {

    public static void main(String[] args) {
        InsertSection insertSection = new InsertSection();
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10}, {12,6}};
        int[] newInterval = new int[]{4,8};
        insertSection.insert(intervals,newInterval);
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        //存储结果集
        List<int[]> retList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean isInsert = false;

        for (int i = 0; i < intervals.length; i++) {
            //区间在左侧并且不重叠
            if (!isInsert && right < intervals[i][0]) {
                retList.add(new int[]{left, right});
                isInsert = true;
            }

            //判断是否重叠
            if (left <= intervals[i][1] && right >= intervals[i][0]) {
                left = Math.min(intervals[i][0], left);
                right = Math.max(intervals[i][1], right);
                continue;
            }

            //依次放入结果集，如果不在左侧并且不重叠那么一定在右侧
            retList.add(intervals[i]);
        }

        //防止一直在合并最后没有加入结果集
        if (!isInsert) {
            retList.add(new int[]{left, right});
        }

        int[][] ret = new int[retList.size()][2];

        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }

        return ret;

    }


}
