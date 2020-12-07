package com.zc.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 *
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 *
 * 提示：
 *
 *     0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/3 9:47
 * @modified
 */
public class CountPries {

    //暴力超时
    public int countPrimes(int n) {
        if (n<=2){
            return 0;
        }
        int ret = 0;
        for (int i=n-1; i>=2; i--){
            if (isPries(i)){
                ret++;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
//        CountPries countPries = new CountPries();
//        countPries.countPrimes2(10);
        double a = -0.11;
        System.out.println((int)a);
    }

    private static boolean isPries(int input){
        for (int i=2; i<=Math.sqrt(input); i++){
            if (input%i==0){
                return false;
            }
        }

        return true;
    }

    //埃氏筛
    public int countPrimes2(int n) {
        if (n<=2){
            return 0;
        }
        int ret = 0;
        int[] retArray = new int[n];
        Arrays.fill(retArray,1);
        for (int i=2; i<n; i++){
            if (retArray[i] == 1){
                ret++;
                if ((long)i*i<n){
                    int multiplier = i*i;
                    while (multiplier<n){
                        System.out.println(multiplier+"-");
                        retArray[multiplier] = 0;
                        multiplier+=i;
                    }
                }
            }

        }
        return ret;
    }

}
