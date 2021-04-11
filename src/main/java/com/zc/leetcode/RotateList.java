package com.zc.leetcode;

import com.zc.Test.ListNode;

/**
 * 61. 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 示例 2：
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 *
 *
 * 提示：
 *
 *     链表中节点的数目在范围 [0, 500] 内
 *     -100 <= Node.val <= 100
 *     0 <= k <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author CoreyChen Zhang
 * @Date: 2021/03/27/ 11:00
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        //排除空链表
        if (head == null){
            return head;
        }
        ListNode indexNode = head;
        //index 本身不是null  length +1
        length ++;
        while (indexNode.next != null){
            length++;
            indexNode = indexNode.next;
        }

        //组成循环链表
        indexNode.next = head;
        k = k % length;
        int move = length - k;
        for (int i = 0; i < move; i++) {
            indexNode = indexNode.next;
        }
        ListNode result = indexNode.next;
        indexNode.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode index2 = new ListNode(2);
        ListNode index3 = new ListNode(3);
        ListNode index4 = new ListNode(4);
        ListNode index5 = new ListNode(5);
        root.next = index2;
        index2.next = index3;
        index3.next = index4;
        index4.next = index5;
        RotateList rotateList = new RotateList();
        rotateList.rotateRight(root,2);
    }
}
