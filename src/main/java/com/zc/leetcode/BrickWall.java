package com.zc.leetcode;

import java.util.*;

/**
 *
 * 554. 砖墙
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/5/2 14:22
 * @modified
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int length = wall.size();
        List<Integer> tierList = wall.get(0);
        int n = tierList.stream().mapToInt(a -> a).sum();
        if (n == 1){
            return length;
        }

        Map<Integer, Integer> wallMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int curLength = 0;
            List<Integer> list = wall.get(i);
            for (Integer gap : list){
                curLength += gap;
                if (curLength < n){
                    if (null != wallMap.get(curLength)){
                        wallMap.put(curLength, wallMap.get(curLength) + 1);
                    }else {
                        wallMap.put(curLength, 1);
                    }
                }
            }
        }

        return wallMap.values().size() == 0 ? length :  length - wallMap.values().stream().mapToInt(value -> value).max().getAsInt();
    }

    public static void main(String[] args) {
        BrickWall brickWall = new BrickWall();
        List<List<Integer>> input = new ArrayList<>();
//        input.add(Arrays.asList(1,2,2,1));
//        input.add(Arrays.asList(3,1,2));
//        input.add(Arrays.asList(1,3,2));
//        input.add(Arrays.asList(2,4));
//        input.add(Arrays.asList(3,1,2));
//        input.add(Arrays.asList(1,3,1,1));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(2));
        brickWall.leastBricks(input);
    }
}
