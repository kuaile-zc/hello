package com.zc.leetcode;

/**
 * 938. 二叉搜索树的范围和
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 *
 *
 * 提示：
 *
 *     树中节点数目在范围 [1, 2 * 104] 内
 *     1 <= Node.val <= 105
 *     1 <= low <= high <= 105
 *     所有 Node.val 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/4/27 16:33
 * @modified
 */
public class RangeSumBST {

    private int result;

    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        bfs(root, low, high);
        return result;
    }

    private void bfs(TreeNode root, int low, int high){
        if (null == root){
            return;
        }

        bfs(root.left, low, high);
        if (root.val >= low && root.val <= high){
            result += root.val;
        }
        bfs(root.right, low, high);
    }
}
