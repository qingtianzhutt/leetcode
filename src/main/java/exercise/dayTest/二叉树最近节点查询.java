package exercise.dayTest;

import exercise.git.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
返回数组 answer 。
 */
public class 二叉树最近节点查询 {
    //二叉搜索树，从头开始遍历，左中右。 这个需要使用中序遍历，而不是前序遍历啊。
    //又超出时间限制了。
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                cur = temp.right;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        for (int num : queries){
            int l = -1, r = -1;
            for (int i = index; i < list.size(); i++){
                if (list.get(i) < num){
                    l = i;
                    index = Math.max(l, 0);
                }else if (list.get(i) > num){
                    r = i;
                    break;
                }else if (list.get(i) == num){
                    l = i;
                    r = i;
                    break;
                }
            }
            res.add(Arrays.asList(l != -1 ? list.get(l) : -1 , r != -1 ? list.get(r) : -1));
        }
        return res;
    }
    //二叉树中序遍历 + 二分查找
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                cur = temp.right;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int num = queries.get(i);
            res.add(findNum(list, num));
        }
        return res;
    }
    //找
    public List<Integer> findNum(List<Integer> list, int num){
        int l = 0, r = list.size() - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if (list.get(mid) == num){
                return Arrays.asList(list.get(mid), list.get(mid));
            }else if (list.get(mid) < num){
                l = mid + 1;
            }else if (list.get(mid) > num){
                r = mid - 1;
            }
        }
        return null;


    }
}
