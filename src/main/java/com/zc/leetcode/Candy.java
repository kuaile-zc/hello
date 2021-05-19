package com.zc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 *     每个孩子至少分配到 1 个糖果。
 *     相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/24 9:45
 * @modified
 */
public class Candy {

    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length==0){
            return 0;
        }
        int[] candy = new int[length];
        Arrays.fill(candy,1);

        int[][] ratingSort = new int[length][2];
        for (int i=0; i<length; i++){
            ratingSort[i][0] = i;
            ratingSort[i][1] = ratings[i];
        }

        Arrays.sort(ratingSort ,Comparator.comparingInt(value -> value[1]));

        for (int i=0; i<length; i++){
            int index = ratingSort[i][0];
            int score = ratings[index];
            //看左边的小朋友是否给糖果少了
            if (index-1>=0 && score<ratings[index-1] && candy[index] >= candy[index-1]){
                candy[index-1] = candy[index] + 1;
            }
            //看右边的小朋友是否给糖果少了
            if (index+1<length && score<ratings[index+1] && candy[index] >= candy[index+1]){
                candy[index+1] = candy[index] + 1;
            }
        }

        int sum = Arrays.stream(candy).sum();

        return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        candy.candy(new int[]{2,1,2,3,1,4,5});
        String str1= "abc";
        String str2= new String("abc");
        String str3= str2.intern();
        System.out.println(str1==str2);
        System.out.println(str2==str3);
        System.out.println(str1==str3);

    }

}
