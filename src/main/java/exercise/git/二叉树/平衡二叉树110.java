package exercise.git.二叉树;
/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]
返回 true 。
 */
//1.层序也可以做。
public class 平衡二叉树110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1)return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    public int height(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return judgeHeight(root) != -1;
    }


    public int judgeHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int lLen = judgeHeight(root.left);
        int rLen = judgeHeight(root.right);
        //如果左边不平衡或者右边不平衡或者   当前左右不平衡
        if (lLen == -1 || rLen == -1 || Math.abs(lLen - rLen) > 1)return -1;
        return Math.max(judgeHeight(root.left), judgeHeight(root.right)) + 1;
    }
}
