package com.zc.leetcode;

import com.zc.Test.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
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
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/25 16:17
 * @modified
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        //前置添加哨兵模式
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root, cur = head, next = head;
        //设置初始条件当head本身为空的时候
        if (cur == null){
            return root.next;
        }

        next = next.next;
        while (next != null){
            //判断当前值与后续值是否相等，相等则遍历到不相等或者null位置
            while (next != null && cur.val == next.val){
                next = next.next;
            }

            //判断当前值的下一个是否是next如果不是表示有相同值需要删除
            if (cur.next != next){
                //由于不相等表示有重复，直接忽略中间的值将前置节点连接到next节点
                pre.next = next;
                cur = next;
            }else {  //如果是则表示无相同值所以index顺序后移
                pre = cur;
                cur = next;
            }

            //确认next还能继续移动
            if (next!=null){
                next = next.next;
            }
        }

        return root.next;
    }
}
