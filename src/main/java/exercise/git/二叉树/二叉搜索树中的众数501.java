package exercise.git.二叉树;

import java.util.*;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
 */
public class 二叉搜索树中的众数501 {
    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                //统计次数
                map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
                cur = temp.right;
            }
        }
        int maxTimes = 0;
        List<Integer> list = new ArrayList<>();
        for(int val : map.values()){
            maxTimes = Math.max(maxTimes, val);
        }
        for (int key : map.keySet()){
            if (map.get(key) == maxTimes) {
                list.add(key);
            }
        }
        //这里的   lambda到底是是怎么用的。
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    //来个迭代，利用二叉搜索树特性的.
    //记住前一个节点。
    public int[] findMode2(TreeNode root) {
        if (root == null) return null;
        int maxCount = 1;
        int curCount = 0;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                if (pre == null || temp.val != pre.val){
                    curCount = 1;
                }else if (temp.val == pre.val){
                    curCount++;
                }
                pre = temp;
                if (curCount == maxCount){
                    list.add(temp.val);
                }else if (curCount > maxCount){
                    maxCount = curCount;
                    list.clear();
                    list.add(temp.val);
                }
                cur = temp.right;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
