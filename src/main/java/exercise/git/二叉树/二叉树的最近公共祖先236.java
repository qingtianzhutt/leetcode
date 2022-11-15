package exercise.git.二叉树;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class 二叉树的最近公共祖先236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode leftRes = lowestCommonAncestor(root.left, p ,q);
        if (leftRes != null) return leftRes;
        TreeNode rightRes = lowestCommonAncestor(root.right, p ,q);
        if (rightRes != null) return rightRes;
        if (isSon(root, p) && isSon(root, q))return root;
        if (isSon(root, p)) p = root;
        if (isSon(root, q)) q = root;
        return null;

    }
    public boolean isSon(TreeNode root, TreeNode q){
        if (root.left == q || root.right == q || root == q) {
            return true;
        }
        return false;
    }
}
