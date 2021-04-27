package com.zc.leetcode;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 *
 *     如果字符串的长度为 1 ，算法停止
 *     如果字符串的长度 > 1 ，执行下述步骤：
 *         在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 *         随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 *         在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 *
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 *
 * 示例 2：
 *
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 *
 *
 *
 * 提示：
 *
 *     s1.length == s2.length
 *     1 <= s1.length <= 30
 *     s1 和 s2 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/4/16 14:25
 * @modified
 */
public class ScrambleString {
    //记忆剪枝法
    int[][][] memo;
    String s1, s2;

    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        this.memo = new int[length][length][length+1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0,0,length);
    }

    //第一个字符从l1开始 第二个字符从 l2开始 子串长度为length
    private boolean dfs(int l1, int l2, int length){
        if (memo[l1][l2][length] != 0){
            return memo[l1][l2][length] == 1;
        }

        //判断两个子串是否相等
        String childStr1 = s1.substring(l1, l1+length);
        String childStr2 = s2.substring(l2, l2+length);
        if (childStr1.equals(childStr2)){
            memo[l1][l2][length] = 1;
            return true;
        }

        if (!checkIfSimilar(childStr1, childStr2)){
            memo[l1][l2][length] = -1;
            return false;
        }

        //枚举分割位置
        for (int i = 1; i < length; i++) {
            //不交换
            if (dfs(l1, l2, i) && dfs(l1+i, l2+i, length-i)){
                memo[l1][l2][length] = 1;
                return true;
            }

            //交换
            if (dfs(l1, l2+ length-i, i) && dfs(l1+i, l2, length-i)){
                memo[l1][l2][length] = 1;
                return true;
            }
        }

        memo[l1][l2][length] = -1;
        return false;

    }

    private boolean checkIfSimilar(String s1, String s2){
        int[] str1 = calStr(s1);
        int[] str2 = calStr(s2);
        for (int i = 0; i < 26; i++) {
            if (str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }

    private int[] calStr(String str){
        int[] ret = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ret[str.charAt(i) - 'a']++;
        }
        return ret;
    }

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        scrambleString.isScramble("abc", "acb");
    }
}
