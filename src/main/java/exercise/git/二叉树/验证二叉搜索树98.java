package exercise.git.二叉树;
/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */

import java.util.Stack;

public class 验证二叉搜索树98 {
    //先来一遍中序遍历    左中右
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //注意搜索树中有int类型的最小值。
        long temp = Long.MIN_VALUE;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if (cur.val <= temp) return false;
                temp = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

    //递归方法，直接遍历就行了
    private long max = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return false;
        boolean l = true;
        if (root.left != null){
            l = isValidBST2(root.left);
        }
        if (!l)return false;
        if (root.val <= max) {
            return false;
        }
        max = root.val;
        return root.right == null || isValidBST2(root.right);
    }
}
