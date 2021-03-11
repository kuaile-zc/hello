package com.zc.leetcode;

import java.util.*;

/**
 * 395. 至少有K个重复字符的最长子串
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 104
 *     s 仅由小写英文字母组成
 *     1 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/02/27/ 12:22
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        int length = s.length();
        if (length==0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c-'a', map.getOrDefault(c-'a',0)+1);
        }

        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue()<k){
                int left = longestSubstring(s.substring(0,s.indexOf((char)'a' + entry.getKey())), k);
                int right = longestSubstring(s.substring(s.indexOf((char)'a' + entry.getKey())+1), k);
                return Math.max(left, right);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters a = new LongestSubstringWithAtLeastKRepeatingCharacters();
        a.longestSubstring("aaabb",3);
    }
}
