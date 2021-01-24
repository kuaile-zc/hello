package com.zc.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 738. 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 *
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 *
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 *
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/15 10:06
 * @modified
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if (N<10){
            return N;
        }
        int digit = -1;
        int[] digitValue = new int[10];
        int[] digitMax = new int[10];
        while (N!=0){
            int value = N%10;
            digitValue[++digit] = value;
            N = N/10;
        }

        for (int i=digit; i>0; i--){
            if (digitValue[i] > digitValue[i-1]){
                int base = digitMax[digitValue[i]];
                if (base <= i){
                    base = i;
                }
                digitValue[base]--;
                for (int j=base-1; j>=0; j--){
                    digitValue[j] = 9;
                }
                break;
            }else if (digitValue[i] == digitValue[i-1]){
                digitMax[digitValue[i]] =  Math.max(i, digitMax[digitValue[i]]);
            }
        }

        int ret = 0;
        int multi = 1;
        for (int i=0; i<=digit; i++){
            ret += multi*digitValue[i];
            multi*=10;
        }

        return ret;
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        monotoneIncreasingDigits.monotoneIncreasingDigits(9999998);
        monotoneIncreasingDigits.test1();

    }

    private void test1(){
        Test test = new Test("100,200");
        Test test2 = new Test("400,500");
        Test test3 = new Test("600,700");
        List<Test> list = new ArrayList<>();
        list.add(test);
        list.add(test2);
        list.add(test3);
        Set<String> collect = list.stream().map(Test::getSupervisePeopleUnitId).flatMap(str -> Arrays.stream(str.split(","))).collect(Collectors.toSet());
        System.out.println();
    }

    @Data
    @AllArgsConstructor
    public class Test{
        private String supervisePeopleUnitId;
    }
}
