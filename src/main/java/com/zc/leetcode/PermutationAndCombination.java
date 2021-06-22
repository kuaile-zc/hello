package com.zc.leetcode;

/**
 * 输出排列组合
 *
 * @author CoreyChen Zhang
 * @version 2020/12/29 11:55
 * @modified
 */
public class PermutationAndCombination {
    private static char[] charArray;
    private static boolean[] signs;
    private static boolean newLine = false;


    public static void main(String[] args) {

        printPermutation("abc");
    }
    /**
     * 输出s的全排列
     *
     * @param s
     */
    public static void printPermutation(String s) {
        if (s == null){
            return;
        }
        charArray = s.toCharArray();
        printPmt(0, charArray.length - 1);
    }

    /**
     * 打印charArray从low到high的所有排列
     *
     * @param low
     * @param high
     */
    private static void printPmt(int low, int high) {
        if (low >= high) {
            print(charArray[low] + "\n");
            newLine = true;
        } else {
            for (int i = low; i <= high; i++) {
                exchChars(low, i);
                if (newLine) {
                    printFromHead(0, low - 1);
                    newLine = false;
                }
                print(charArray[low]);
                printPmt(low + 1, high);
                exchChars(low, i);
            }
        }
    }

    /**
     * 输出s的全组合
     *
     * @param s
     */
    public static void printCombination(String s) {
        if (s == null){
            return;
        }
        charArray = s.toCharArray();
        signs = new boolean[charArray.length];
        printCombination(0, charArray.length - 1);
    }

    /**
     * @param low
     * @param high
     */
    private static void printCombination(int low, int high) {

        if (low > high) {
            for (int i = 0; i < charArray.length; i++) {
                if (signs[i]){
                    print(charArray[i]);
                }
            }
            print("\n");
        } else {
            //输出有第一个字符的组合
            signs[low] = true;
            printCombination(low + 1, high);
            //输出没有有第一个字符的组合
            signs[low] = false;
            printCombination(low + 1, high);
        }
    }

    /**
     * 从i打印到j
     *
     * @param i
     */
    private static void printFromHead(int i, int j) {
        for (int k = i; k <= j; k++) {
            print(charArray[k]);
        }
    }

    /**
     * 交换charArray索引为j，k的字符
     *
     * @param j
     * @param k
     */
    private static void exchChars(int j, int k) {
        if (j == k){
            return;
        }
        char temp = charArray[j];
        charArray[j] = charArray[k];
        charArray[k] = temp;
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    private static void println(Object o) {
        System.out.println(o);
    }
}
