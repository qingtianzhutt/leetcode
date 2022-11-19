package exercise.dayTest;

import java.util.ArrayList;
import java.util.List;

/*
一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
输入：nums = [2,1,3]
输出：6
解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
宽度之和是 6 。
 */
//思路，使用回溯法找到所有的子序列，然后找到所有子序列的宽度之和。
public class 子序列宽度之和891 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public int sumSubseqWidths(int[] nums) {


//        dfs(nums);
        int sum = 0;


        return 0;
    }
}
