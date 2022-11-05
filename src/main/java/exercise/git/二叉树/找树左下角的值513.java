package exercise.git.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/*
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:
 */
//直接层序遍历解决。遍历每一层的第一个
public class 找树左下角的值513 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int res = 0;
        while(!que.isEmpty()){
            int len = que.size();
            for (int i = 0; i < len; i++){
                TreeNode cur = que.poll();
                if (cur.left != null){
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
                if (i == 0) {
                    res = cur.val;
                }
            }
        }
        return res;
    }
}
