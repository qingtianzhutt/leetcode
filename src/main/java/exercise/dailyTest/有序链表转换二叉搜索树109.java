package exercise.dailyTest;

import exercise.git.二叉树.TreeNode;
import exercise.git.链表.ListNode;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

public class 有序链表转换二叉搜索树109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return getRoot(list, 0, list.size() - 1);
    }
    private TreeNode getRoot(List<Integer> list, int l, int r){
        if (l == r){
            return new TreeNode(list.get(l));
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        if (mid - 1 >= l){
            root.left = getRoot(list, l, mid - 1);
        }
        if (mid + 1 <= r){
            root.right = getRoot(list, mid + 1, r);
        }
        return root;
    }
}
