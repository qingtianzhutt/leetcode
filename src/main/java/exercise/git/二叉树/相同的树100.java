package exercise.git.二叉树;

import java.util.Deque;
import java.util.LinkedList;

/*
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class 相同的树100 {
    //递归法
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    //迭代法
    public boolean isSameTree2(TreeNode p, TreeNode q) {
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
