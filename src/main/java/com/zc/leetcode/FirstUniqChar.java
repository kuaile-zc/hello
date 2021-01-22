package com.zc.leetcode;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 *
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/23 9:47
 * @modified
 */
public class FirstUniqChar {
    //字符串操作
    public int firstUniqChar(String s) {
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='A'){
                continue;
            }
            char c = s.charAt(i);
            if (s.substring(i+1).lastIndexOf(c)==-1){
                return i;
            }else {
                s = s.replace(c, 'A');
            }
        }

        return -1;
    }

    //容易理解
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++){
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    //比较快
    public int firstUniqChar3(String s){
        if(s.length() == 1) {
            return 0;
        }
        int[] judgeArray = new int[26];
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(judgeArray[c - 'a'] == 1) {
                continue;
            }else {
                int tempIndex = s.indexOf(c, i + 1);
                if(tempIndex == -1) {
                    index = i;
                    return index;
                }else {
                    judgeArray[c - 'a'] = 1;
                }
            }
        }
        return index;
    }



    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        firstUniqChar.firstUniqChar3("loveleetcode");
    }
}
