package com.zc.leetcode;

import java.util.Arrays;

/**
 * @author CoreyChen Zhang
 * @version 2020/11/10 10:12
 * @modified
 */
public class NextArrange {

    public static void main(String[] args) {
        NextArrange nextArrange = new NextArrange();
        nextArrange.nextPermutation(new int[]{2,2,7,5,4,3,2,2,1});
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int exchange = 0;
        //循环找到从右到左的降序并取得交换位置
        for (int i=length-1; i > -1; i--){
            if (i == 0){
                Arrays.sort(nums);
                return;
            }

            if (nums[i-1] < nums[i]){
                exchange = i-1;
                break;
            }
        }

        int exchangeValue = nums[exchange];

        int exchange2 = exchange + 1;
        int exchangeValue2 = nums[exchange2];
        for (int i = exchange2 ; i < length; i++){
            if (exchangeValue < nums[i] && exchangeValue2 > nums[i]){
                exchangeValue2 = nums[i];
                exchange2 = i;
            }
        }

        int tempInt = 0;
        tempInt = nums[exchange];
        nums[exchange] = nums[exchange2];
        nums[exchange2] = tempInt;

        int[] temp = new int[length- (exchange+1)];
        for (int i=0; i<temp.length; i++){
            temp[i] = nums[exchange+1+i];
        }
        Arrays.sort(temp);
        //正叙插入
        for (int i=0; i<temp.length; i++){
            nums[exchange+1+i] = temp[i];
        }

    }
}
