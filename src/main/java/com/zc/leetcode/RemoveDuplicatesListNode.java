package com.zc.leetcode;

import com.zc.Test.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 *
 * 提示：
 *
 *     链表中节点数目在范围 [0, 300] 内
 *     -100 <= Node.val <= 100
 *     题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/03/26/ 20:31
 */
public class RemoveDuplicatesListNode {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        //防止链表为空
        if (cur == null){
            return head;
        }
        ListNode next = cur.next;

        //循环直到next 为空
        while (cur != null){
            next = cur.next;
            while (next != null && cur.val == next.val){
                next = next.next;
            }

            if (cur.next != next){
                cur.next = next;
            }

            cur = next;
        }

        return head;
    }
}
