package exercise.git.二叉树;

import java.util.LinkedList;
import java.util.Queue;
//需要注意的是，只有当左右孩子都为空的时候，才说明遍历的最低点了。如果其中一个孩子为空则不是最低点
public class 二叉树的最小深度111 {
    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }

    //使用递归法
    public int minDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }
        int lenl = minDepth(root.left);
        int lenr = minDepth2(root.right);
        return Math.min(lenl, lenr) + 1;
    }
}
