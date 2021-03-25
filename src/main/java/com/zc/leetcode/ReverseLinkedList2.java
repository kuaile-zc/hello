package com.zc.leetcode;

import com.zc.Test.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/18 16:45
 * @modified
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode indexNode = root, cur = root, next = root, pre = root;
        for (int index = 0; index <= right; index++) {
            if (index == left-1){
                pre = indexNode;
            }else if (index == left){
                cur = indexNode;
            }else if (index>left){
                next = cur.next;
                reverseListNode(pre, cur, next);
            }

            indexNode = indexNode.next;
        }

        return root.next;
    }

    private void reverseListNode(ListNode pre, ListNode cur, ListNode next){
        ListNode temp = pre.next;
        pre.next = next;
        cur.next = next.next;
        next.next = temp;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(2);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        ListNode root5 = new ListNode(5);
        root.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;

        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        reverseLinkedList2.reverseBetween(root, 2,4);
    }
}
