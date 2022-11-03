package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if(i != index && i > 0 && candidates[i] == candidates[i - 1])continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
