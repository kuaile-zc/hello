package com.zc.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= dominoes.length <= 40000
 *     1 <= dominoes[i][j] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/26 16:36
 * @modified
 */
public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int length = dominoes.length;
        Map<Pairs, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Pairs pairs1 = new Pairs(dominoes[i][0], dominoes[i][1]);
            Pairs pairs2 = new Pairs(dominoes[i][1], dominoes[i][0]);
            if (map.containsKey(pairs1)){
                map.put(pairs1, map.get(pairs1) + 1);
            }else if (map.containsKey(pairs2)){
                map.put(pairs2, map.get(pairs2) + 1);
            }else {
                map.put(pairs1, 0);
            }
        }

        int ret = 0;
        for (Integer i : map.values()){
            if (i>0){
                ret += (i*(i+1))/2;
            }
        }

        return ret;
    }

    class Pairs{
        private int x;
        private int y;

        public Pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
           if (o instanceof Pairs){
               Pairs pairs = (Pairs) o;
               if ( (pairs.getX()==x && pairs.getY()==y) || (pairs.getX()==y && pairs.getY()==x)){
                   return true;
               }
           }
           return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


    public int numEquivDominoPairs2(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino: dominoes){
            if (domino[0]<=domino[1]){
                ret += num[10*domino[0] + domino[1]]++;
            }else {
                ret += num[10*domino[1] + domino[0]]++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        NumberOfEquivalentDominoPairs numberOfEquivalentDominoPairs = new NumberOfEquivalentDominoPairs();
        numberOfEquivalentDominoPairs.numEquivDominoPairs(new int[][]{{2,1},{1,2},{1,2},{1,2},{2,1},{1,1},{1,2},{2,2}});
    }
}
