package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: [1,2,2]
输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
//说明：解集不能包含重复的子集。
//注意这里为什么要保证有序？   一开始其实是不明白的。
public class 子集二90 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int start){
        res.add(new ArrayList<>(path));
        if (start == nums.length)return;
        for (int i = start; i < nums.length; i++) {
            //剪枝
            if (i != start && nums[i] == nums[i - 1])continue;
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    //使用数组来表示是否使用过。
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, used);
        return res;
    }
    private void dfs(int[] nums, int start, int[] used){
        res.add(new ArrayList<>(path));
        if (start == nums.length)return;
        for (int i = start; i < nums.length; i++) {
            //和上面是一样的意思
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)continue;
            path.add(nums[i]);
            used[i] = 1;
            dfs(nums, i + 1);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
