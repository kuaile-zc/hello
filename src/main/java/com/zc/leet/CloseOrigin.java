package com.zc.leet;

import java.util.*;

/**
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 *
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 *
 * 提示：
 *
 *     1 <= K <= points.length <= 10000
 *     -10000 < points[i][0] < 10000
 *     -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/9 10:15
 * @modified
 */
public class CloseOrigin {
    Random rand = new Random();

    public static void main(String[] args) {
        CloseOrigin closeOrigin = new CloseOrigin();
        int[][] input = new int[][]{{3,3},{5,-1},{-2,4}};
        closeOrigin.kClosest2(input,2);

        int[] input2 = new int[]{8,10,5,3,1,7,2};
        closeOrigin.quickSort(input2);
        System.out.println(input2);
    }


    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1]) ));
        return Arrays.copyOfRange(points, 0, K);
    }

    //快速排序推演
    public int[][] kClosest2(int[][] points, int K) {
        quickSortMethod2(points, 0, points.length-1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickSortMethod2(int[][] points, int left, int right, int K){


    }


    //快速排序
    public void quickSort(int[] nums){
        //选定基础位置
        quickSortMethod(nums, 0, nums.length - 1);
    }

    private void quickSortMethod(int[] nums, int left, int right){
        if(left >= right){
            return;
        }

        int i,j,temp,base;
        i = left;
        j = right;
        base = nums[i];

        while (i < j){
            //先动j从右往左走
            while (nums[j] >= base && i < j){
                j--;
            }

            //然后从左往右走
            while (nums[i] <= base && i < j){
                i++;
            }

            //满足交换条件
            if (i < j){
                //交换
                switchNum(nums,i,j);
            }

        }

        //出来必然相等i==j
        switchNum(nums, left, i);
        //依次将左右两边也类似处理
        quickSortMethod(nums, left,i-1);
        quickSortMethod(nums,i+1, right);

    }

    private void switchNum(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void swap(int[][] points, int a, int b){
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}
