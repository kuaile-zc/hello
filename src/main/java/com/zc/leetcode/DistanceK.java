package com.zc.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 *
 * 提示：
 *
 *     给定的树是非空的。
 *     树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 *     目标结点 target 是树上的结点。
 *     0 <= K <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author CoreyChen Zhang
 * @date 2021/7/28 18:24
 * @modified
 */
public class DistanceK {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    int k;
    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        AddRootDfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        dfs(target, 0, null);
        return result;
    }

    private void AddRootDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            map.put(treeNode.left, treeNode);
        }
        if (treeNode.right != null) {
            map.put(treeNode.right, treeNode);
        }
        AddRootDfs(treeNode.left);
        AddRootDfs(treeNode.right);
    }

    private void dfs(TreeNode treeNode, int curIndex, TreeNode pre) {
        if (curIndex == k) {
            result.add(treeNode.val);
            return;
        }
        if (map.get(treeNode) != null && map.get(treeNode) != pre ){
            dfs(map.get(treeNode), curIndex+1, treeNode);
        }
        if (treeNode.left != null && treeNode.left != pre ){
            dfs(treeNode.left, curIndex+1, treeNode);
        }
        if (treeNode.right != null && treeNode.right != pre ){
            dfs(treeNode.right, curIndex+1, treeNode);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode target = new TreeNode(5);
        TreeNode rootRight = new TreeNode(1);

        TreeNode targetRight = new TreeNode(2);
        targetRight.left = new TreeNode(7);
        targetRight.right = new TreeNode(4);

        target.left = new TreeNode(6);
        target.right = targetRight;

        rootRight.left = new TreeNode(0);
        rootRight.right = new TreeNode(8);

        root.left = target;
        root.right = rootRight;

        DistanceK distanceK = new DistanceK();
        distanceK.distanceK(root, target, 2);
    }

}
