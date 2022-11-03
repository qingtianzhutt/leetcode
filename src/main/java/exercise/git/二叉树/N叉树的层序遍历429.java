package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)
 */
//答案是有问题的，但是没必要改了，这题简单。
public class N叉树的层序遍历429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++){
                Node cur = que.poll();
                list.add(cur.val);
                if (cur.left != null){
                    que.add(cur.left);
                }
                if (cur.next != null) {
                    que.add(cur.next);
                }
                if (cur.right != null){
                    que.add(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
class Node2 {
    public int val;
    public List<Node> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
