package com.zc.interview;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-05-13 9:55
 */
public class CheckAnswerFromArrayTwoValue {

    public static void main(String[] args) {
        Integer[] arrays = {3,7,12,0,7,15,9,77,200,4,17,52,66,11,91};
        Integer response = 15+17  ;
        checkResult(arrays, response);
    }


    public static void checkResult(Integer[] arrays, Integer response){
        Arrays.sort(arrays);
        Arrays.stream(arrays).forEach(System.out::println);
        for (int i = 0 , j=arrays.length-1;;) {
            if (arrays[i]+arrays[j] == response){
                System.out.println("This twwo value is : "+arrays[i]+ "  " +arrays[j]);
                break;
            }else if(arrays[i]+arrays[j] > response){
                j = j - 1;
            }else {
                i = i + 1;
            }

        }

    }
}
