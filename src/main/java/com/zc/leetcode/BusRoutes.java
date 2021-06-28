package com.zc.leetcode;

import java.util.*;

/**
 * 815. 公交路线
 *
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 *     例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 *
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 *
 *
 * 提示：
 *
 *     1 <= routes.length <= 500.
 *     1 <= routes[i].length <= 105
 *     routes[i] 中的所有值 互不相同
 *     sum(routes[i].length) <= 105
 *     0 <= routes[i][j] < 106
 *     0 <= source, target < 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/6/28 13:51
 * @modified
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target){
            return 0;
        }
        int buRouteNums = routes.length;
        Map<Integer, List<Integer>> routesMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        //初始化第一站
        for (int i = 0; i < buRouteNums; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < routes[i].length; j++) {
                list.add(routes[i][j]);
            }
            if (list.contains(source)){
                queue1.offer(i);
                visited.add(i);
            }
            routesMap.put(i, list);
        }

        //如果没有开始站
        if (queue1.isEmpty()){
            return -1;
        }
        int step = 1;
        while (!queue1.isEmpty()) {
            List<Integer> stationList = routesMap.get(queue1.poll());
            if (stationList.contains(target)){
                return step;
            }
            for (Integer station : stationList){
                List<Integer> busRoutes = getBusRoutes(station, routesMap);
                for (Integer busRoute : busRoutes){
                    if (!visited.contains(busRoute)){
                        queue2.offer(busRoute);
                        visited.add(busRoute);
                    }
                }
            }
            //交换
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                step++;
            }

        }


        return -1;
    }

    private List<Integer> getBusRoutes(Integer station, Map<Integer, List<Integer>> routesMap) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : routesMap.entrySet()){
            if (entry.getValue().contains(station)){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BusRoutes busRoutes = new BusRoutes();
        busRoutes.numBusesToDestination(new int[][]{{7,12}, {4,5,15}, {6}, {15,19}, {9,12,13}}, 1, 6);
    }
}
