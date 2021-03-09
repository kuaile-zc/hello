package com.zc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.DelayQueue;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 20000
 *     S 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/9 14:49
 * @modified
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        TreeSet<Integer> set = new TreeSet<>();
        do {
            if (set.size()>0){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < S.length(); i++) {
                    if (!set.contains(i)){
                        sb.append(S.charAt(i));
                    }
                }
                S = sb.toString();
                set.clear();
            }

            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i)==S.charAt(i-1) && !set.contains(i-1) && !set.contains(i)){
                    set.add(i-1);
                    set.add(i);
                }
            }
        }while (set.size()!=0);

        return S;
    }


    public String removeDuplicates2(String S) {
        LinkedList<Character> deque = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (!deque.isEmpty() && deque.peekFirst()==S.charAt(i)){
                deque.pollFirst();
                continue;
            }
            deque.offerFirst(S.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()){
            stringBuilder.append(deque.pollLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.removeDuplicates2("abbaca");
    }


}
