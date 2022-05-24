package com.zc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author corey
 * @creat 2022/5/22 12:30
 * @describe https://leetcode.cn/problems/can-i-win/
 */
public class CanIWin {

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        canIWin.canIWin(7, 16);
    }

    private int length = 0;
    private Map<Integer, Boolean> memory = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > ((1 + maxChoosableInteger) * maxChoosableInteger) / 2) {
            return false;
        }
        length = maxChoosableInteger;
        return dfs(0, 0, desiredTotal);
    }

    /**
     * 输入：当前局面，包括可选的「公共整数池」，「已选择的数字」之和，desiredTotal。
     * 输出：当前做选择的玩家一定能赢吗？
     * <p>
     * g公共整数池使用 010101 表示 0表示存在 1 表示已经被取走
     * 1.
     * 如果当前做选择的玩家在「公共整数池」中选择 xxx，如果选择了 xxx 之后，对手继续玩一定会输，那么当前玩家一定赢。
     * 2.
     * 如果当前的玩家把「公共整数池」全部遍历判断了，但无论选择哪个数字，对手都一定赢，那么当前玩家就一定输。
     */
    public boolean dfs(int numPool, int curTotal, int desiredTotal) {
        if (!memory.containsKey(numPool)) {
            boolean result = false;
            for (int i = 0; i < length; i++) {
                if ((numPool >> i & 1) == 1) {
                    continue;
                }
                if (curTotal + i + 1 >= desiredTotal) {
                    result = true;
                    break;
                }
                //如果对手稳输false那么我方就稳赢
                if (!dfs(numPool | (1 << i), curTotal + i + 1, desiredTotal)) {
                    result = true;
                    break;
                }
            }
            memory.put(numPool, result);
        }
        return memory.get(numPool);
    }
}
