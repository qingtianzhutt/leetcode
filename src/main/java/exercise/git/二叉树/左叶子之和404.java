package exercise.git.二叉树;

import java.util.Stack;

/*
计算给定二叉树的所有左叶子之和。
示例：
 */
public class 左叶子之和404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null)return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                //说明是左叶子节点
                if (cur.left.left == null && cur.left.right == null){
                    sum += cur.left.val;
                }
            }
        }
        return sum;
    }
    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if (root == null)return 0;
        if (root.left != null && isSon(root.left)){
            sum += root.left.val;
        }else if (root.left != null){
            sum += sumOfLeftLeaves2(root.left);
        }
        if (root.right != null && !isSon(root.right)){
            sum += sumOfLeftLeaves2(root.right);
        }
        return sum;

    }
    private boolean isSon(TreeNode root){
        if (root.left == null && root.right == null)return true;
        return false;
    }

    //递归法，写一个成一个，美滋滋
    public int sumOfLeftLeaves3(TreeNode root) {
        int sum = 0;
        if (root == null)return 0;
        return count(root);

    }
    public int count(TreeNode root){
        if (root == null){
            return 0;
        }
        int sum = count(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        sum += count(root.right);
        return sum;
    }
}
