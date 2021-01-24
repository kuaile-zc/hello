package com.zc.leetcode;

import java.util.Arrays;

/**
 * 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 *
 * 提示：
 *
 *     2 <= A.length <= 20000
 *     A.length % 2 == 0
 *     0 <= A[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2020/11/12 9:37
 * @modified
 */
public class OddEvenNumber {
    public static void main(String[] args) {
       int[] A = new int[]{648,831,560,986,192,424,997,829,897,843};
       OddEvenNumber  oddEvenNumber = new OddEvenNumber();
       oddEvenNumber.sortArrayByParityII2(A);
    }

    //暴力法
    public int[] sortArrayByParityII(int[] A) {
        //建立奇数偶数下标
        int oddIndex=1, eventIndex=0;
        int[] ret = new int[A.length];

        for (int i=0; i<A.length; i++){
            if (A[i]%2 == 0){
                ret[eventIndex] = A[i];
                eventIndex+=2;
            }else {
                ret[oddIndex] = A[i];
                oddIndex+=2;
            }
        }

        return ret;
    }

    //优化一次以下遍历
    public int[] sortArrayByParityII2(int[] A) {
        //建立临时数用于存放需要交换的值   前面储存偶数后面储存奇数
        int[] tempExchange = new int[A.length/2];
        Arrays.fill(tempExchange,-1);
        int index = 0;
        for (int i=0; i<A.length; i+=2){
            if (i%2 != A[i]%2){
                tempExchange[index++] = i;
            }

        }

        int i = 1;
        while (index != 0){
            if (i%2 != A[i]%2){
                exchange(i, tempExchange[--index], A);
            }
            i+=2;
        }

        return A;
    }

    private void exchange(int xIndex, int yIndex, int[] A){
        int temp = A[xIndex];
        A[xIndex] = A[yIndex];
        A[yIndex] = temp;
    }
}
