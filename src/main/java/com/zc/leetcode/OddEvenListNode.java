package com.zc.leetcode;

import com.zc.Test.ListNode;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 *
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 说明:
 *
 *     应当保持奇数节点和偶数节点的相对顺序。
 *     链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author CoreyChen Zhang
 * @version 2020/11/13 10:18
 * @modified
 */
public class OddEvenListNode {
    public ListNode oddEvenList(ListNode head) {
        ListNode index = head;
        //初始化前三个节点，如果长度小于3那么直接返回原始值
        if (null == index ){
            return head;
        }
        //定义快慢指针
        ListNode slow = index.next;
        ListNode fast ;

        while (slow!=null && slow.next!=null){
            fast = slow.next;
            //交换奇数到最前面
            slow.next = fast.next;
            fast.next = index.next;
            index.next = fast;
            //奇数基准点往前进一位
            index = index.next;
            slow = slow.next;
        }

        return head;
    }
}
