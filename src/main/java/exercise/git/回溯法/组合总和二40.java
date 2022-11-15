package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明： 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。
示例 1: 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
示例 2: 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 */
//结果中不能包含重复的元素，所以这里在回溯的时候就要考虑到重复的情况。
public class 组合总和二40 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }
    private void dfs(int[] candidates, int target, int index){
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i])return;
            //这对同一层中用到的相同元素进行剪纸
            if(i != index && candidates[i] == candidates[i - 1])continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    private void dfs2(int[] candidates, int target, int index){
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++){
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
