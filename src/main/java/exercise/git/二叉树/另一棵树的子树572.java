package exercise.git.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 */
//也算一次通过
public class 另一棵树的子树572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.val == subRoot.val){
                if (isSameTree(cur, subRoot)) {
                    return true;
                }
            }
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deq = new LinkedList<>();
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        deq.addFirst(p);
        deq.addLast(q);
        //相当于用两个栈，后进先出,这里用的是前序遍历   相当于两个栈两个二叉树一起遍历每一个节点。
        while(!deq.isEmpty()){
            TreeNode p1 = deq.pollFirst();
            TreeNode q1 = deq.pollLast();
            if (p1.val != q1.val) {
                return false;
            }
            if ((p1.right == null && q1.right != null) || (p1.right != null && q1.right == null)) return false;
            if ((p1.left == null && q1.left != null) || (p1.left != null && q1.left == null)) return false;
            if (p1.right != null) deq.addFirst(p1.right);
            if (p1.left != null) deq.addFirst(p1.left);
            if (q1.right != null) deq.addLast(q1.right);
            if (q1.left != null) deq.addLast(q1.left);
        }
        return true;
    }
}
