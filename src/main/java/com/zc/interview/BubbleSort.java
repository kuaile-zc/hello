package com.zc.interview;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:冒泡排序
 *
 * @author Corey Zhang
 * @create 2020-05-18 20:43
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6,8,1,0,12,3,20,11};
        System.out.println("Before---------------");
        Arrays.stream(arr).forEach(System.out::println);

        //Sort
        for (int i = 0; i < arr.length-1; i++ ){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j+1] < arr [j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("After---------------");
        Arrays.stream(arr).forEach(System.out::println);
    }
}
