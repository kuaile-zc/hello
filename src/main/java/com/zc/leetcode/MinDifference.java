package com.zc.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     2 <= timePoints <= 2 * 104
 *     timePoints[i] 格式为 "HH:MM"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2022/1/18 10:26
 * @modified
 */
public class MinDifference {

    public int findMinDifference(List<String> timePoints) {
        int length = timePoints.size();
        int[] timeNum = new int[length];
        for (int i = 0; i < length; i++) {
            timeNum[i] = translateTimeToNum(timePoints.get(i));
        }
        Arrays.sort(timeNum);
        int result = translateTimeToNum("24:00") - timeNum[length-1] + timeNum[0];
        for (int i = 1; i < length; i++) {
            int diff = timeNum[i] - timeNum[i-1];
            if (result > diff) {
                result = diff;
            }
            if (result == 0) {
                return 0;
            }
        }
        return result;
    }

    public int translateTimeToNum(String time) {
        String[] split = time.split(":");
        return Integer.valueOf(split[0])*60+Integer.valueOf(split[1]);
    }

    public static void main(String[] args) {
        MinDifference minDifference = new MinDifference();
        minDifference.translateTimeToNum("00:59");
    }

}
