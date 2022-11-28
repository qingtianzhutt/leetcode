package exercise.dailyTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class 三角形最小路径和120 {
    private int res = Integer.MAX_VALUE;
    //超过时常了。
    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return res;
    }
    private void dfs(List<List<Integer>> list, int row, int col, int sum){
        if (row == list.size()){
            res = Math.min(res, sum);
            return;
        }
        int curVal = list.get(row).get(col);
        dfs(list, row + 1, col, sum + curVal);
        dfs(list, row + 1, col + 1, sum + curVal);
    }
    //这种题目也可以动态规划
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++){
            for (int j = 0; j <=i; j++){
                if (j == 0){
                    dp[i][j] = dp[i - 1][0] + triangle.get(i).get(j);
                }else if (j == i){
                    dp[i][j] = dp[i - 1][i - 1] + triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }

    @Test
    public void test(){
        int[][] nums = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
        List<List<Integer>> triangle = Arrays.stream(nums).map(l -> Arrays.stream(l).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        minimumTotal2(triangle);

    }
}
