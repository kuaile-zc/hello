package com.zc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/04/25/ 23:15
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bfs(list, root);
        TreeNode result = new TreeNode(list.get(0));
        TreeNode index = result;
        for (int i = 1; i < list.size(); i++) {
            index.right = new TreeNode(list.get(i));
            index = index.right;
        }
        return result;
    }

    private void bfs(List<Integer> list, TreeNode treeNode){
        if (treeNode == null){
            return;
        }

        bfs(list, treeNode.left);
        list.add(treeNode.val);
        bfs(list, treeNode.right);
    }
}
