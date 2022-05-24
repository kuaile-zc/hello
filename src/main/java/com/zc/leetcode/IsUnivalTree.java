package com.zc.leetcode;

/**
 * @author corey
 * @creat 2022/5/24 09:44
 * @describe https://leetcode.cn/problems/univalued-binary-tree/
 */
public class IsUnivalTree {

    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (null != root.left &&  root.left.val != root.val) {
            return false;
        }
        if (null != root.right &&  root.right.val != root.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

}
