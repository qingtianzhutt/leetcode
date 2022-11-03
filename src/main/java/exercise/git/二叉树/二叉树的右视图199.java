package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class 二叉树的右视图199 {
    /**
     * 解法：队列，迭代。
     * 每次返回每层的最后一个字段即可。
     *
     * 小优化：每层右孩子先入队。代码略。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return list;
        }
        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                if (poll.left != null) {
                    que.addLast(poll.left);
                }
                if (poll.right != null) {
                    que.addLast(poll.right);
                }
                //在遍历每一层的时候将最后一个元素加进去。
                if (i == levelSize - 1) {
                    list.add(poll.val);
                }
            }
        }
        return list;
    }
    //层序遍历每次读最后一个数据。
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return res;
        }
        que.add(root);
        while (!que.isEmpty()){
            int len = que.size();
            for (int i = 0; i < len; i++){
                TreeNode cur = que.poll();
                if (i == len - 1){
                    res.add(cur.val);
                }
                if (cur.left != null){
                    que.add(cur.left);
                }
                if (cur.right != null){
                    que.add(cur.right);
                }
            }
        }
        return res;
    }
}
