package com.zc.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 *     0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 *     F.length >= 3；
 *     对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 *
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 示例 2：
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 *
 * 示例 3：
 *
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 *
 * 示例 4：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 *
 * 示例 5：
 *
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 200
 *     字符串 S 中只含有数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Corey Zhang
 * @modified:
 * @version: 2020-12-08 23:10
 */
public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        backtrack(S.toCharArray(), res, 0);
        return res;
    }

    public boolean backtrack(char[] digit, List<Integer> res, int index) {
        //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
        if (index == digit.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < digit.length; i++) {
            //两位以上的数字不能以0开头
            if (digit[index] == '0' && i > index) {
                break;
            }
            //截取字符串转化为数字
            long num = subDigit(digit, index, i + 1);
            //如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                //把数字num添加到集合res中
                res.add((int) num);
                //如果找到了就直接返回
                if (backtrack(digit, res, i + 1))
                    return true;
                //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    //相当于截取字符串S中的子串然后转换为十进制数字
    private long subDigit(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i] - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        splitIntoFibonacci.splitIntoFibonacci("0123");
    }


}
