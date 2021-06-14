package com.zc.leetcode;

/**
 * @author CoreyChen Zhang
 * @date 2021/6/14 9:32
 * @modified
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        if (n == 1 || guess(n) == 0) {
            return n;
        }
        int left = 1, right = n;
        while (true){
            int mid = left + (right-left)/2;
            int guess = guess(mid);
            if (guess == 0){
                return mid;
            }else if (guess == -1){
                right = mid;
            }else {
                left = mid;
            }
        }
    }

    public int guess(int num){
        if (num == 6){
            return 0;
        }
        return num > 6? -1:1;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();
        guessNumberHigherOrLower.guessNumber(10);
    }
}
