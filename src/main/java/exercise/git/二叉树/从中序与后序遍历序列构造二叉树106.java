package exercise.git.二叉树;

import java.util.HashMap;

/*
根据一棵树的中序遍历与后序遍历构造二叉树。
注意: 你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7] 后序遍历 postorder = [9,15,7,20,3] 返回如下的二叉树：
 */
//这题背下来好了，没什么用。
public class 从中序与后序遍历序列构造二叉树106 {
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    //前闭后开
    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd){
        if (inBegin >= inEnd || postBegin >= postEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        int headIndex = map.get(root.val);
        int inLen = headIndex - inBegin;
        root.left = findNode(inorder, inBegin, headIndex, postorder, postBegin, postBegin + inLen);
        root.right = findNode(inorder, headIndex + 1, inEnd, postorder, postBegin + inLen, postEnd - 1);
        return root;
    }
}
