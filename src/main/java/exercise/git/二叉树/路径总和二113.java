package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
 */
public class 路径总和二113 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path);
        return res;
    }
    //回溯中要注意path一定要回滚。
    public void dfs(TreeNode root, int targetSum, List<Integer> path){
        if (root == null)return;
        if (root.val == targetSum && root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val, path);
        dfs(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }

    public void dfs2(TreeNode root, int targetSum, List<Integer> path){
        if (root == null)return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        dfs2(root.left, targetSum - root.val, path);
        dfs2(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }
}
