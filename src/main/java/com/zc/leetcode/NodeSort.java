package com.zc.leetcode;

import com.zc.Test.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 *     你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *示例 1：
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     链表中节点的数目在范围 [0, 5 * 104] 内
 *     -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/11/21 8:59
 * @modified
 */
public class NodeSort {
    //考虑用快排
    public ListNode sortList(ListNode head) {
        //考虑边界
        if (null == head || null == head.next){
            return head;
        }
        //计数器
        int count = 0;
        ListNode indexNode = head;
        while (null != indexNode){
            count++;
            indexNode = indexNode.next;
        }
        int[] intArray = new int[count];
        count=0;
        while (null != head){
            intArray[count++] = head.val;
            head = head.next;
        }

        //快排预置位
        fastSort(intArray, 0, intArray.length-1);
        ListNode ret = new ListNode(intArray[0]);
        ListNode index = ret;
        for(int i=1; i<intArray.length; i++){
            ListNode listNode = new ListNode(intArray[i]);
            index.next = listNode;
            index = index.next;
        }

        return ret;
    }

    //快排
    private void fastSort(int[] intArray, int left, int right){
        if (left>=right){
            return;
        }
        //找基准
        int base = left, temp=0, i = left, j = right, baseValue = intArray[base];
        while (i<j){
            while (intArray[j] >= baseValue && i<j){
                j--;
            }
            while (intArray[i] <= baseValue && i<j){
                i++;
            }
            if (i<j){
                temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
            }
        }
        //交换基准
        intArray[left] = intArray[i];
        intArray[i] = baseValue;
        fastSort(intArray, left, i-1);
        fastSort(intArray, i+1, right);

    }

    public static void main(String[] args) {
        NodeSort nodeSort = new NodeSort();
        int[] ints = {4, 2, 1, 3};
        nodeSort.fastSort(ints, 0, ints.length-1);
    }
}
