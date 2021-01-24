package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author CoreyChen Zhang
 * @version 2020/12/26 20:02
 * @modified
 */
public class LargestRectangleInHistogram {
    //暴力
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length==0){
            return 0;
        }

        int ret = 0;
        for (int i=0; i<length; i++){
            int leftIndex = i;
            int rightIndex = i;
            int height = heights[i];
            while (leftIndex>0 && heights[leftIndex-1]>=height){
                leftIndex--;
            }

            while (rightIndex<length-1 && heights[rightIndex+1]>=height){
                rightIndex++;
            }

            int width = rightIndex-leftIndex+1;
            ret = Math.max(ret, width*height);
        }

        return ret;
    }


    //使用栈
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len+2];
        for (int i=0; i<len; i++){
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.offer(0);
        for (int i = 1; i < newHeights.length; i++) {
            int height = heights[i];
            while (height < heights[stack.peekLast()]){
                int curHeight = heights[stack.pollLast()];
                int wide =i - stack.peekLast() -1;
                res = Math.max(res, wide*curHeight);
            }
            stack.offer(i);
        }
        return res;
    }


    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        largestRectangleInHistogram.largestRectangleArea2(new int[]{2,1,0,2});
    }
}
