package com.zc.interview;

import java.util.Arrays;

/**
 * Description: 正序数组随机插入一个数
 *
 * @author Corey Zhang
 * @create 2020-05-13 13:56
 */
public class InsertNumberIntoPositiveSeq {
    public static void main(String[] args) {
        int[] arrays = {3,7,12,25,55,67,77,80,100,120,665,991,1000};
        int insertNumber = 1001;
        Arrays.stream(dichotomyFunction(arrays, insertNumber)).forEach(System.out::println);
    }


    public static int[] dichotomyFunction(int[] arrays, int insertNumber){
        int rightIndex = arrays.length;
        int leftIndex = 0;
        int halfIndex = (rightIndex+leftIndex)/2;
        while (true){
            if ( halfIndex==0 || halfIndex== arrays.length ||   ( insertNumber >= arrays[halfIndex-1]   &&  insertNumber <= arrays[halfIndex]  ) ){
                return insertArray(arrays, insertNumber, halfIndex);
            }else if ( insertNumber < arrays[halfIndex-1]  ){
                rightIndex = halfIndex;
                halfIndex = halfIndex/2;
            }else {
                leftIndex = halfIndex;
                halfIndex = (rightIndex+leftIndex)/2;
                if (leftIndex == halfIndex)
                    halfIndex = arrays.length;
            }

        }
    }

    public static int[] insertArray(int[] arrays, int insertNumber, int index){
        int[] retArrays = new int[arrays.length+1];
        for (int i = 0; i < retArrays.length; i++){
            if (i < index){
                retArrays[i] = arrays[i];
            }else if (i == index){
                retArrays[i] = insertNumber;
            }else if (i > index){
                retArrays[i] = arrays[i-1];
            }

        }

        return retArrays;
    }
}
