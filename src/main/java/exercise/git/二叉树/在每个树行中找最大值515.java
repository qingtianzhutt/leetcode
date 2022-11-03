package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
您需要在二叉树的每一行中找到最大的值。
 */
//贼简单
public class 在每个树行中找最大值515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++){
                TreeNode cur = que.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    que.add(cur.left);
                }
                if (cur.right != null) {
                    que.add(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
