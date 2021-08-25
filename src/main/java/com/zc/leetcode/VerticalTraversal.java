package com.zc.leetcode;

import java.util.*;

/**
 * @Author CoreyChen Zhang
 * @Date: 2021/07/31/ 11:32
 */
public class VerticalTraversal {

    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    Map<TreeNode, int[]> sitMap = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new int[]{0,0});

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Collections.sort(queue, (o1, o2) -> o1.val - o2.val);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int[] ints = sitMap.get(poll);
                List<Integer> list = map.getOrDefault(ints[1], new ArrayList<>());
                list.add(poll.val);
                map.put(ints[1], list);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void dfs(TreeNode treeNode, int[] site) {
        if (treeNode == null) {
            return;
        }
        sitMap.put(treeNode, site);
        dfs(treeNode.left, new int[]{site[0] + 1, site[1] - 1});
        dfs(treeNode.right, new int[]{site[0] + 1, site[1] + 1});
    }

    public static void main(String[] args) {
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        TreeNode root = new TreeNode(3);
        TreeNode right = new TreeNode(20);
        root.left = new TreeNode(9);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.right = right;
        verticalTraversal.verticalTraversal(root);
    }
}
