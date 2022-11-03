package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.List;
//子集是收集树形结构中树的所有节点的结果
public class 子集78 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start){
        res.add(new ArrayList<>(path));
        if (start == nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
