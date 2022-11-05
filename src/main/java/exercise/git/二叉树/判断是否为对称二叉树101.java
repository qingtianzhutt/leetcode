package exercise.git.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 判断是否为对称二叉树101 {
    /**
     * 递归法
     */
    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }
    //直接秒杀官方写法，无敌。
    private boolean compare1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //是比较外侧和内侧，注意递归条件。
        return compare1(left.left, right.right) && compare1(left.right, right.left);

    }

    /**
     * 迭代法
     * 使用双端队列，相当于两个栈
     */
    //这种deque可以模拟两个栈。自己也可以想出来。
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

    /**
     * 迭代法
     * 使用普通队列
     */
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }



    public boolean isSymmetric4(TreeNode root) {
        if (root == null)return true;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val != root.right.val) return false;
        return isSymmetric4(root.left) && isSymmetric4(root.right);
    }

    //使用队列
    public boolean isSymmetric5(TreeNode root) {
        if (root == null)return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()){
            int len = que.size();
            while(len-- > 0){
                TreeNode left = que.poll();
                TreeNode right = que.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null || left.val != right.val) {
                    return false;
                }
                //这里的进栈顺序就是一会的出栈顺序，进去的左右左右 是对称的一组。  左右都可以。
                que.offer(left.left);
                que.offer(right.right);
                que.offer(right.left);
                que.offer(left.right);
            }
        }
        return true;
    }
}
