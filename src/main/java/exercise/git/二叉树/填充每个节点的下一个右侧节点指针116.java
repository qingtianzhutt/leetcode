package exercise.git.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */
//思路：层序遍历，让当前节点指向右向节点就行了，如果是当前层最后一个节点，指向空,一次成功
public class 填充每个节点的下一个右侧节点指针116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        Deque<Node> queue = new LinkedList<>();
        queue.add(cur);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if (i == len - 1) {
                    temp.next = null;
                }else {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            for (int i = 0; i < len; i++){
                Node cur = que.poll();
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
                if (i == len - 1){
                    cur.next = null;
                }else{
                    cur.next = que.peek();
                }
            }
        }
        return root;
    }

}
