package exercise.git.二叉树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
 */
//这一看就是回溯法。
public class 二叉树的所有路径257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        //new StringBuilder(int) 这样的话，int的意思是这个sb的初始化容量。
        dfs(root, new StringBuilder(String.valueOf(root.val)), res);
        return res;
    }
    private void dfs(TreeNode root, StringBuilder sb, List<String> res){
        if (root.left == null && root.right == null){
            res.add(new String(sb));
        }
        if (root.left != null){
            String s = sb.toString();
            sb.append("->" + root.left.val);
            dfs(root.left, sb, res);
            sb = new StringBuilder(s);
        }
        if (root.right != null){
            String s = sb.toString();
            sb.append("->" + root.right.val);
            dfs(root.right, sb, res);
            sb = new StringBuilder(s);
        }
    }
    @Test
    public void test(){
        StringBuilder sb = new StringBuilder(2);
        sb.append("->" + "t");
        System.out.println(sb);
        //这里也算是sb处理问题的一个方法。
        sb.delete(sb.length() - 3, sb.length());
        System.out.println(sb);
    }


    /**
     * 迭代法
     */
    //这方法也不错
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }

}
