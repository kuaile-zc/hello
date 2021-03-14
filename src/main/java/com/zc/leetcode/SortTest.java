package com.zc.leetcode;

import java.util.Arrays;

/**
 * 此类是练习排序算法
 * @author CoreyChen Zhang
 * @version 2021/3/14 23:05
 * @modified
 */
public class SortTest {

    public static void main(String[] args) {
        int[] test = new int[]{4,2,7,1,100,23,99,86,1023,23,0,13,6};
        SortTest sortTest = new SortTest();
        Arrays.stream(test).forEach(a-> System.out.print(a+"   "));
        System.out.println();
        sortTest.mergeSort(test);
        Arrays.stream(test).forEach(a-> System.out.print(a+"   "));

    }

    //归并排序
    private void mergeSort(int[] arrays){
        splitMergeSort(arrays, 0, arrays.length-1);
    }

    //归并排序 拆分
    private void splitMergeSort(int[] arrays, int left, int right){
        if (left == right){
            return;
        }
        int mid = (right+left)/2;
        splitMergeSort(arrays, left, mid);
        splitMergeSort(arrays, mid+1, right);
        merge(arrays, left, right, mid);
    }

    //归并排序-归并
    private void merge(int[] arrays, int left, int right, int mid){
        int[] temp = new int[right-left+1];
        int index = 0, i = left, j = mid+1;
        while (i <= mid && j <= right){
            if (arrays[i] <= arrays[j]){
                temp[index++] = arrays[i];
                i++;
            }else {
                temp[index++] = arrays[j];
                j++;
            }
        }

        //判断左边区间是否耗尽
        while (i <= mid){
            temp[index++] = arrays[i];
            i++;
        }

        //判断右边区间是否耗尽
        while (j <= right){
            temp[index++] = arrays[j];
            j++;
        }
        index = 0;
        for (int k = left; k <= right; k++) {
            arrays[k] = temp[index++];
        }


    }
}
