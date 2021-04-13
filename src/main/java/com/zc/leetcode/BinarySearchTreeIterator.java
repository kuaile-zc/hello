package com.zc.leetcode;

import java.util.LinkedList;

/**
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 *     BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *     boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *     int next()将指针向右移动，然后返回指针处的数字。
 *
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 *
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 *
 *
 * 示例：
 *
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 *
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 *
 *
 *
 * 提示：
 *
 *     树中节点的数目在范围 [1, 105] 内
 *     0 <= Node.val <= 106
 *     最多调用 105 次 hasNext 和 next 操作
 *
 *
 *
 * 进阶：
 *
 *     你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/3/28 10:35
 * @modified
 */
public class BinarySearchTreeIterator {

    class BSTIterator {

        LinkedList<Integer> data = new LinkedList<>();

        // 初始化
        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        //使用dfs解析树结构 补充知识二叉树遍历（ 前序(根左右)，中序(左根右)，后序(左右根) ）
        //使用的是 中序
        private void dfs(TreeNode root){
            //判断root是否为空
            if (null == root){
                return;
            }
            //先遍历左边
            dfs(root.left);
            //添加根节点
            data.offer(root.val);
            //遍历右边
            dfs(root.right);
        }

        public int next() {
            return data.poll();
        }

        public boolean hasNext() {
            return !data.isEmpty();
        }
    }
}