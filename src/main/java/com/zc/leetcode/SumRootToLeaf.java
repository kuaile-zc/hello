package com.zc.leetcode;

/**
 * @author corey
 * @creat 2022/5/30 18:43
 * @describe https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {

    int result;

    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return;
        }
        sum = sum*2 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            result += sum;
        }
        dfs(treeNode.left, sum);
        dfs(treeNode.right, sum);
    }

    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        left.setLeft(new TreeNode(0));
        left.setRight(new TreeNode(1));
        TreeNode right = new TreeNode(1);
        right.setLeft(new TreeNode(0));
        right.setRight(new TreeNode(1));
        root.setRight(right);
        root.setLeft(left);
        sumRootToLeaf.sumRootToLeaf(root);
    }
}
