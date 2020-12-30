package com.zc.leet;

import com.zc.Test.ListNode;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * <p>
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2020/12/30 9:39
 * @modified
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int length = stones.length;
        int index = length - 1;
        Arrays.sort(stones);
        while (index >= 1) {
            int max = stones[length - 1];
            int second = stones[length - 2];
            if (max == second) {
                stones[length - 1] = 0;
                stones[length - 2] = 0;
                index = index - 2;
            } else {
                stones[length - 1] = 0;
                stones[length - 2] = max - second;
                index--;
            }
            Arrays.sort(stones);
        }

        return index == 0 ? stones[length - 1] : 0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeight(new int[]{3, 4, 2, 3, 1, 124, 54, 1});
        WeakReference<ListNode> referenceListNode = new WeakReference(new ListNode(2));
        System.out.println(referenceListNode.get());
        String[] a = new String[10000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Date().toString();
        }
        System.gc();
        System.out.println(referenceListNode.get());
    }
}
