package com.zc.leet;

import java.util.*;

/**
 * @author CoreyChen Zhang
 * @version 2020/11/16 14:19
 * @modified
 */
public class RebuildArrayByHeight {
    //普通方法
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1,o2)-> o1[0]==o2[0]? o1[1]-o2[1] : o2[0]-o1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] i: people){
            list.add(i[1],i);
        }
        return list.toArray(people);
    }


    public static void main(String[] args) {
        RebuildArrayByHeight rebuildArrayByHeight = new RebuildArrayByHeight();
        int[][] input =new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        rebuildArrayByHeight.reconstructQueue2(input);
    }

    //快速排序法
    public int[][] reconstructQueue2(int[][] people) {
        fastSort(people, 0, people.length-1);
        List<int[]> list = new LinkedList<>();
        for (int[] i: people){
            list.add(i[1],i);
        }
        return list.toArray(people);
    }

    private void fastSort(int[][] people, int left, int right){
        if (left >= right){
            return;
        }
        //选定基准
        int[] base = people[left];
        int i = left;
        int j = right;
        while (i<j){
            while (i<j && compareArray(base, people[j])){
                j--;
            }

            while (i<j && compareArray(people[i], base)){
                i++;
            }

            if (i<j){
                int[] temp = people[i];
                people[i] = people[j];
                people[j] = temp;
            }
        }

        people[left] = people[i];
        people[i] = base;
        fastSort(people, left, i-1);
        fastSort(people, i+1, right);


    }

    /**
     * [7,0]>[7,1]
     * and [7,a] > [6,b]
     * @param a
     * @param b
     * @return a>b   true
     *         a<b   false
     */
    private boolean compareArray(int[] a,int[] b){
        if (a[0]==b[0]){
            return a[1] <= b[1];
        }else {
            return a[0] >= b[0];
        }
    }

}
