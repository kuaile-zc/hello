package com.zc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     树中节点数目在范围 [2, 100] 内
 *     0 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @version 2021/4/13 17:05
 * @modified
 */
public class MinValueBetweenBST {

    public int minDiffInBST(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < path.size(); i++) {
            minValue = Math.min(minValue, Math.abs(path.get(i) - path.get(i-1)));
        }
        return minValue;
    }

    private void dfs(TreeNode root, List<Integer> path){
        if (root == null){
            return;
        }
        dfs(root.right, path);
        path.add(root.val);
        dfs(root.left, path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(48);
        right.left = new TreeNode(12);
        right.right = new TreeNode(99);
        MinValueBetweenBST minValueBetweenBST = new MinValueBetweenBST();
        minValueBetweenBST.minDiffInBST(root);

    }
}
