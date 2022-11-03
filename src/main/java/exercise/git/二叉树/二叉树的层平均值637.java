package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class 二叉树的层平均值637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            Double sum = 0.0;
            for (int i = 0; i < len; i++){
                TreeNode cur = que.poll();
                sum += cur.val;
                if (cur.right != null){
                    que.add(cur.right);
                }
                if (cur.left != null) {
                    que.add(cur.left);
                }
            }
            res.add(sum / len);
        }
        return res;
    }
}
