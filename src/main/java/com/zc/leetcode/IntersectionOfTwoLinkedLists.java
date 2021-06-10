package com.zc.leetcode;

import com.zc.Test.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/06/05/ 11:25
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode copyA = headA, copyB = headB;
        while (copyA != null){
            set.add(copyA);
            copyA = copyA.next;
        }

        while (copyB != null){
            if (set.contains(copyB)){
                return copyB;
            }
            copyB = copyB.next;
        }
        return null;
    }
}
