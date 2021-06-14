package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @date 2021/6/13 10:55
 * @modified
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        boolean theOneVersion = isBadVersion(1);
        if (theOneVersion){
            return 1;
        }
        //使用二分法
        int left = 1, right = n;
        while (right - left != 1){
            int half =left + (right-left)/2;
            boolean halfVersion = isBadVersion(half);
            if (halfVersion){
                right = half;
            }else {
                left = half;
            }
        }
        return right;
    }


    boolean isBadVersion(int version){
        return true;
    }
}
