package exercise.git.二叉树;
/*
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
//二叉搜索树是一个有序树：
//
//若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
//若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
//它的左、右子树也分别为二叉搜索树


import java.util.Stack;

//第一想法，遍历，考虑到二叉搜索数的特性，用前序遍历的速度最快。
public class 二叉搜索树中的搜索700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val == val) {
                return cur;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return null;
    }
    //二叉搜索数的迭代不需要借助于栈和队列
    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null){
            if (val > root.val) {
                root = root.right;
            }else if (val < root.val){
                root = root.left;
            }else{
                return root;
            }
        }
        return null;
    }
}
