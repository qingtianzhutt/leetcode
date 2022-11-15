package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1： 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ]
示例 2： 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
 */
public class 组合总和39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }
    private void dfs(int[] candidates, int target, int cur){
        if (target == 0){
            res.add(new ArrayList<>(path));
        }
        if (target < 0)return;
        //剪纸
        for (int i = cur; i < candidates.length; i++) {
            if (target < candidates[i])return;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //这个是为了剪枝用的。
        Arrays.sort(candidates);
        dfs2(candidates, target, 0);
        return res;
    }
    private void dfs2(int[] candidates, int target, int cur){
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //这里进行剪枝。
        for (int i = cur; i < candidates.length && candidates[i] <= target; i++){
            path.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

}
