package exercise.dailyTest;

import exercise.git.二叉树.TreeNode;

import java.util.Arrays;

public class 将有序数组转换为二叉搜索树108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return getRoot(nums, 0, nums.length - 1);

    }
    public TreeNode getRoot(int[] nums, int l, int r){
        if (l == r){
            return new TreeNode(nums[l]);
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - 1 >= l){
            root.left = getRoot(nums, l, mid - 1);
        }
        if (mid + 1 <= r){
            root.right = getRoot(nums, mid + 1, r);
        }
        return root;
    }

}
