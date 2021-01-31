package com.zc.leetcode;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * 注意:
 *
 *     S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/30 10:31
 * @modified
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int length = S.length();
        if (length<2){
            return S;
        }
        //存放字母数量
        int[][] letters = new int[26][2];
        for (int i=0; i<length; i++){
            char c = S.charAt(i);
            letters[c-'a'][0] = c-'a';
            letters[c-'a'][1]++;
        }

        Arrays.sort(letters, (o1,o2) -> o2[1] - o1[1]);

        if (letters[0][1] > (length+1)/2 ){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < length){
            if (letters[0][1]>0){
                stringBuilder.append((char) (letters[0][0]+'a'));
                letters[0][1]--;
            }

            if (letters[1][1]>0){
                stringBuilder.append((char) (letters[1][0]+'a'));
                letters[1][1]--;
            }

            Arrays.sort(letters, (o1,o2) -> o2[1] - o1[1]);

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        reorganizeString.reorganizeString("aaabbc");
        System.out.println("run---"+Runtime.getRuntime().availableProcessors());
    }
}
