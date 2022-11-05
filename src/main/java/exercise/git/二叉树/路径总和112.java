package exercise.git.二叉树;

/*
相信很多同学都会疑惑，递归函数什么时候要有返回值，什么时候没有返回值，特别是有的时候递归函数返回类型为bool类型。
那么接下来我通过详细讲解如下两道题，来回答这个问题：
112.路径总和
113.路径总和ii
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例:  给定如下二叉树，以及目标和 sum = 22，
 */
public class 路径总和112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        return l || r;
    }
}
