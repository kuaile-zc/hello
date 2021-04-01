package com.zc.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/01/ 22:20
 */
public class ClumsyFactorial {

    public int clumsy(int N) {
        List<Integer> stack = new LinkedList<>();
        int result = N, operationIndex = 0;
        int[] operation = new int[]{0,1,2,3};
        for (int i = N-1; i > 0; i--) {
            switch ((operationIndex++)%4){
                case 0:
                    result *= i;
                    break;
                case 1:
                    result /= i;
                    stack.add(result);
                    result = 0;
                    break;
                case 2:
                    stack.add(i);
                    break;
                case 3:
                    result = -i;
                    break;
            }
        }
        return stack.stream().mapToInt(a->a).sum() + result;

    }

    public static void main(String[] args) {
        ClumsyFactorial clumsyFactorial = new ClumsyFactorial();
        clumsyFactorial.clumsy(4);
    }
}
