package com.zc.leetcode;

/**
 * 567. 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 *
 * 注意：
 *
 *     输入的字符串只包含小写字母
 *     两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/10 10:38
 * @modified
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1>length2){
            return false;
        }

        int[] origin = new int[26];
        int[] target = new int[26];
        for (int i=0; i<length1; i++){
            origin[s1.charAt(i)-'a']++;
            target[s2.charAt(i)-'a']++;
        }

        for (int i = length1; i <= length2; i++) {
            if (isEquals(origin, target)){
                return true;
            }

            if (i<length2){
                target[s2.charAt(i)-'a']++;
                target[s2.charAt(i-length1)-'a']--;
            }
        }
        return false;
    }

    private boolean isEquals(int[] origin, int[] target){
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != target[i]){
                return false;
            }
        }
        return true;
    }

}
