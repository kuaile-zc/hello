package com.zc.leet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2020/12/22 16:41
 * @modified
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        setTreeValue(list, root,0);
        int magic = 1;
        for (int i=0; i<list.size(); i++){
            System.out.println(list.toString());
            if (magic==-1){
                Collections.reverse(list.get(i));
            }
            magic*=-1;
        }
        return list;
    }

    private void setTreeValue(List<List<Integer>> list, TreeNode root, int depth){
        if (root==null){
            return;
        }
        if (list.size()<=depth){
            List<Integer> addList = new ArrayList<>();
            addList.add(root.val);
            list.add(addList);
        }else {
            list.get(depth).add(root.val);
        }
        setTreeValue(list, root.left, depth+1);
        setTreeValue(list, root.right, depth+1);

    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(9);
        TreeNode left = new TreeNode(20);
        left.right = new TreeNode(15);
        left.left = new TreeNode(7);
        root.left = left;
        binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root);
    }
}
