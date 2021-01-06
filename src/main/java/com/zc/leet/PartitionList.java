package com.zc.leet;

import com.zc.Test.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/1/3 22:43
 * @modified
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode zeroNode = new ListNode(0);
        zeroNode.next = head;
        ListNode xPreIndex = zeroNode;
        ListNode index = zeroNode;
        boolean isFindX = false;

        while (null != index.next){
            if (isFindX){
                if (index.next.val<x){
                    //链表交换
                    ListNode temp = index.next;
                    index.next = index.next.next;
                    temp.next = xPreIndex.next;
                    xPreIndex.next = temp;
                    xPreIndex = xPreIndex.next;
                }else {
                    index = index.next;
                }
            }else {
                //未找到x之前
                if (index.next.val >= x){
                    isFindX = true;
                    xPreIndex = index;

                }
                index = index.next;
            }
        }

        return zeroNode.next;
    }

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(5);
        ListNode node10 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        partitionList.partition(head, 3);
    }
}
