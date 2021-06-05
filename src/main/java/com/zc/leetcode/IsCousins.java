package com.zc.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     二叉树的节点数介于 2 到 100 之间。
 *     每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/5/17 9:52
 * @modified
 */
public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        List<Integer> varList = new ArrayList<>();
        //BFS
        while (!stack.isEmpty()){
            varList.clear();
            final int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = stack.pollLast();
                if ( treeNode.right!= null && treeNode.left != null){
                    final boolean isEquals = (treeNode.right.val == x && treeNode.left.val == y) || (treeNode.right.val == y && treeNode.left.val == x);
                    if (isEquals){
                        return false;
                    }
                }
                //添加左右子节点
                if (treeNode.right != null){
                    varList.add(treeNode.right.val);
                    stack.addFirst(treeNode.right);
                }
                if (treeNode.left != null){
                    varList.add(treeNode.left.val);
                    stack.addFirst(treeNode.left);
                }
            }

            if (varList.contains(x) && varList.contains(y)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsCousins isCousins = new IsCousins();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        isCousins.isCousins(treeNode,2,3);
    }
}
