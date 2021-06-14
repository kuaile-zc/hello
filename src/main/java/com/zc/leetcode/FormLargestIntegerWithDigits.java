package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @date 2021/6/12 15:41
 * @modified
 */
public class FormLargestIntegerWithDigits {

    //动态规划，滚动数组
    public String largestNumber(int[] cost, int target) {
        int length = cost.length;
        String[] dp = new String[target+1];
        dp[0] = "";

        for (int i = 0; i < length; i++) {
            int costValue = cost[i];
            for (int j = costValue; j <= target; j++) {
                if (dp[j-costValue] != null){
                    dp[j] = getMaxStr(dp[j], String.valueOf(i+1)+dp[j-costValue]);
                }
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }

    private String getMaxStr(String str1, String str2) {
        if (str1 == null){
            return str2;
        }
        int length1 = str1.length(), length2 = str2.length();
        if (length1 > length2) {
            return str1;
        } else if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if ((int) str1.charAt(i) > (int) str2.charAt(i)){
                    return str1;
                }else if ((int) str1.charAt(i) < (int) str2.charAt(i)){
                    return str2;
                }
            }
        }
        return str2;
    }

    public static void main(String[] args) {
        FormLargestIntegerWithDigits formLargestIntegerWithDigits = new FormLargestIntegerWithDigits();
        formLargestIntegerWithDigits.largestNumber(new int[]{4,3,2,5,6,7,2,5,5}, 9);
    }
}
