package exercise.dailyTest;

import exercise.git.二叉树.TreeNode;
/*
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class 二叉树中的最大路径和124 {
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        longestRoad(root);
        return res;
    }
    private int longestRoad(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftCount = Math.max(longestRoad(root.left), 0);
        int rightCount = Math.max(longestRoad(root.right), 0);
        res = Math.max(res, root.val + leftCount + rightCount);
        return root.val + Math.max(leftCount, rightCount);
    }
}
