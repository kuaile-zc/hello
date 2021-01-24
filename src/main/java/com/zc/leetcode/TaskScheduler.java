package com.zc.leetcode;

/**
 * Description:
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-05 20:19
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int length = tasks.length;
        if (n==0){
            return length;
        }

        int replace = -1;
        int max = 0;
        int[] ret = new int[26];
        for (int i=0; i<length; i++){
            max = Math.max(max, ++ret[tasks[i] - 'A']);
        }

        for (int i=0; i<26; i++){
            if (ret[i] == max){
                replace++;
            }
        }

        int base = max * (replace + 1);
        int remain = (n-replace)*(max-1);
        if ((length-base) <= remain ){
            return base+remain;
        }else {
            return length;
        }
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'},2);
    }
}
