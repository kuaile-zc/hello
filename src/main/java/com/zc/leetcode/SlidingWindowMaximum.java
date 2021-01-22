package com.zc.leetcode;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 *     1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/2 13:12
 * @modified
 */
public class SlidingWindowMaximum {
    //超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==1){
            return nums;
        }
        int length = nums.length;
        int[] ret = new int[length-k+1];
        int index = 0;
        int maxValue = nums[0];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        ret[index++] = maxValue;

        for (int i = 1; i < ret.length; i++) {
            int value = nums[k-1+i];
            //新加入的数是队列最大数
            if (value>=maxValue){
                ret[index++]=value;
                maxValue = value;
                queue.poll();
                queue.offer(value);
            }else {
                int lastValue = queue.poll();
                //出队列的数不是最大数
                if (lastValue!=maxValue){
                    ret[index++]=maxValue;
                    queue.offer(value);
                }else {
                    //出队列的数是最大数（需要遍历找出最大数。头大）
                    queue.offer(value);
                    int tempMaxValue = Integer.MIN_VALUE;
                    for (Integer number : queue){
                        if (number>tempMaxValue){
                            tempMaxValue = number;
                        }
                    }
                    maxValue = tempMaxValue;
                    ret[index++]=maxValue;
                }

            }
        }

        return ret;
    }


    //使用优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k==1){
            return nums;
        }

        //int[2] 第一位放值第二位放下标
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }

        ret[0] = queue.peek()[0];
        for (int i = 1; i < ret.length; i++) {
            queue.add(new int[]{nums[k+i-1], k+i-1});
            while (queue.peek()[1]<i){
                queue.poll();
            }
            ret[i] = queue.peek()[0];
        }

        return ret;
    }


    //使用单调队列
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (k==1){
            return nums;
        }

        //int[2] 第一位放值第二位放下标
        Deque<Integer> queue = new LinkedList<>();

        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        ret[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);

            while (queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            ret[i-k+1] = nums[queue.peekFirst()];
        }

        return ret;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.maxSlidingWindow3(new int[]{100,99,98,97,96,95,94,93,92}, 3);
    }
}
