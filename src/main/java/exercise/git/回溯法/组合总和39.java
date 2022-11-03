package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
