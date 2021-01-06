package com.zc.leet;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * 给你 n ，请计算 F(n) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 *
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *
 *
 *
 * 提示：
 *
 *     0 <= n <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/4 9:24
 * @modified
 */
public class FibonacciNumber {
    //基础
    public int fib(int n) {
        if (n==0){
            return 0;
        }else if (n==1){
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }

    //打表
    public int fib2(int n) {
        int[] ret = new int[]{0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040};
        return ret[n];
    }

    //滚动结果
    public int fib3(int n){
        if (n<2){
            return n;
        }
        int a=0;
        int b=1;
        int c=1;
        for (int i=3; i<=n; i++){
            a=b;
            b=c;
            c=a+b;
        }
        return c;
    }
}
