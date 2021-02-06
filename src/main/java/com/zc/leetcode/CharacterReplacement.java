package com.zc.leetcode;

/**
 * 424. 替换后的最长重复字符
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 *
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/2/2 10:08
 * @modified
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int ret = 0 , left = 0 , right = 0 , length = s.length(), maxCharNum = 0;
        char[] chars = s.toCharArray();
        int[] letter = new int[26];
        if (length<2){
            return length;
        }
        while (right<length) {
            letter[chars[right]-'A']++;
            maxCharNum = Math.max(maxCharNum, letter[chars[right]-'A']);
            right++;

            int slideLength = right - left;
            if (slideLength-maxCharNum>k){
                letter[chars[left]-'A']--;
                left++;
            }

            ret = Math.max(ret, right - left);
        }

        return ret;
    }


    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        characterReplacement.characterReplacement("AABABBA", 1);
    }
}
