package exercise.git.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 */
public class 二叉搜索树的最小绝对差530 {
    //中序   迭代
    //牛逼，一次通过。
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sub = Integer.MAX_VALUE;
        TreeNode curLeft = root;
        while(curLeft.left != null){
            curLeft = curLeft.left;
        }
        int beforeNum = curLeft.val;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode pop = stack.pop();
                //这里是中序遍历对当前数进行计算的地方。
                if (pop.val != beforeNum){
                    sub = Math.min(sub, pop.val - beforeNum);
                    beforeNum = pop.val;
                }
                cur = pop.right;
            }
        }
        return sub;
    }
    //最简单的当然是直接中序遍历然后求差了。
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sub = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode pop = stack.pop();
                //这里是中序遍历对当前数进行计算的地方。
                list.add(pop.val);
                cur = pop.right;
            }
        }

        for (int i = 1; i < list.size(); i++){
            sub = Math.min(sub, list.get(i) - list.get(i - 1));
        }
        return sub;

    }
}
