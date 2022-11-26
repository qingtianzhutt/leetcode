package exercise.dayTest;

import exercise.git.二叉树.TreeNode;

/*
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：
例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。
叶节点 是指没有子节点的节点。
 */
public class 求根节点到叶节点数字之和129 {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode curNode, int sum){
        if (curNode.left == null && curNode.right == null){
            res += sum * 10 + curNode.val;
            return;
        }
        if (curNode.left != null){
            dfs(curNode.left, sum * 10 + curNode.val);
        }
        if (curNode.right != null){
            dfs(curNode.right, sum * 10 + curNode.val);
        }
    }

}
