package exercise.git.回溯法;

import java.util.*;
/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */
public class 全排列46 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }
    private void dfs(int[] nums){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        dfs2(nums);
        return res;
    }
    private void dfs2(int[] nums){
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length && !used[i]; i++){
            path.add(nums[i]);
            used[i] = true;
            dfs(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
