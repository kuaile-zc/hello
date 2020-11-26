package com.zc.leet;

import com.zc.Test.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2020/11/20 9:58
 * @modified
 */
public class LinkInsertSort {

    //按题目要求插入算法
    public ListNode insertionSortList(ListNode head) {
        if (null == head){
            return null;
        }

        //建立一个新的链表
        ListNode ret = new ListNode(head.val);
        ListNode index = head.next;
        while (null != index){
            int value = index.val;
            ListNode insertNode = new ListNode(value);
            ListNode fastNode = ret;
            ListNode slowNode = null;
            if (value<=fastNode.val){
                insertNode.next = ret;
                ret = insertNode;
            }else {
                while (fastNode!=null){
                    if (fastNode.val>=value){
                        break;
                    }
                    slowNode = fastNode;
                    fastNode = fastNode.next;
                }
                slowNode.next = insertNode;
                insertNode.next = fastNode;
            }

            index = index.next;

        }

        return ret;
    }

    //
    public ListNode insertionSortList2(ListNode head) {
        if (null == head){
            return null;
        }
        //创建排序列表
        List<Integer> list = new ArrayList<>();
        ListNode index = head;
        while (index!=null){
            list.add(index.val);
            index = index.next;
        }

        Collections.sort(list);
        ListNode ret =new ListNode(list.get(0));
        index = ret;
        for (int i=1; i<list.size(); i++){
            ListNode listNode = new ListNode(list.get(i));
            index.next = listNode;
            index = index.next;
        }

        return ret;
    }

}
