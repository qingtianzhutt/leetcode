package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//如何去重呢
public class 递增子序列491 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start){
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        //使用set来保证同一层中不出现重复的元素。
        //因为数组不是有序排列的，所以没法使用i != start && nums[i] == nums[i - 1]来降重。
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            //保证存起来的是递增数组。
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)){
                set.add(nums[i]);
                path.add(nums[i]);
                dfs(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    @Test
    public void test(){
        int[] nums = {1,2,3,1,2,3};
        System.out.println(findSubsequences(nums));
    }
}
