package exercise.git.二叉树;

import java.util.Stack;

/*
给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 */
//我简直恐怖如斯。hhhhh,一次成功。
public class 恢复二叉搜索树99 {
    public void recoverTree(TreeNode root) {
        TreeNode bigNode = null, smallNode = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode leftNode = null;
        while(!stack.isEmpty() || cur != null){
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode temp = stack.pop();
                if (leftNode != null){
                    if (temp.val < leftNode.val){
                        if (bigNode == null) {
                            bigNode = leftNode;
                        }
                        smallNode = temp;
                    }
                }
                leftNode = temp;
                cur = temp.right;
            }
        }
        int tempVal = bigNode.val;
        bigNode.val = smallNode.val;
        smallNode.val = tempVal;
    }
}
