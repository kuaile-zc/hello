package com.zc.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 10000
 *     0 <= A[i] <= 9
 *     0 <= K <= 10000
 *     如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/22 9:59
 * @modified
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int length = A.length;
        boolean check = false;

        List<Integer> ret = new ArrayList<>();
        int add = 0;
        for (int i = length - 1; i >= 0 || K!=0; i--) {
            int digit = K%10;
            int a = 0;
            if (i>=0){
                a = A[i];
            }
            int value = digit + a + add;
            K = K/10;
            if (value>=10){
                value = value % 10;
                add = 1;
            }else {
                add = 0;
            }
            ret.add( value);
        }

        if (add==1){
            ret.add(1);
        }

        Collections.reverse(ret);
        return ret;
    }


    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
        addToArrayFormOfInteger.addToArrayForm(new int[]{2,7,4}, 181);
    }

}
