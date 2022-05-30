package com.zc.leetcode;

/**
 * @author corey
 * @creat 2022/5/27 15:15
 * @describe https://leetcode.cn/problems/find-closest-lcci/
 */
public class FindClosest {

    public static void main(String[] args) {
        FindClosest findClosest = new FindClosest();
        findClosest.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"},"a", "student");
    }

    public int findClosest(String[] words, String word1, String word2) {
        int[] index = new int[]{-1,-1};
        int result = words.length;
        for (int i = 0; i < words.length; i++) {
            if (!word1.equals(words[i]) && !word2.equals(words[i])) {
                continue;
            }else if (word1.equals(words[i])) {
                index[0] = i;
            }else {
                index[1] = i;
            }
            if (index[0] != -1 && index[1] != -1) {
                result = Math.min(result, Math.abs(index[0] - index[1]));
            }
        }
        return result;
    }
}
