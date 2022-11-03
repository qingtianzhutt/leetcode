package exercise.git.动态规划.零一背包;

import org.junit.Test;

import java.util.Arrays;

public class 划分数组和为和相等的两部分 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        if (Arrays.stream(nums).sum()%2 != 0) {
            return false;
        }
        int m = nums.length;
        int n = Arrays.stream(nums).sum() / 2;
        int max = Arrays.stream(nums).max().getAsInt();
        if (max > n) {
            return false;
        }
        Boolean[][] dp = new Boolean[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[m][n];
    }

    //写一个回溯法
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return dfs(nums, sum / 2, 0);
    }
    private boolean dfs(int[] nums, int sum, int index){
        if (sum == 0) {
            return true;
        }else if (sum < 0){
            return false;
        }
        boolean l = false;
        for (int i = index; i < nums.length; i++) {
            if (dfs(nums, sum - nums[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    //写一个动态规划
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        //注意： Boolean[][] dp中的每个元素是null，而不是false. boolean[][]  里面的才是false.
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < sum / 2 + 1; i++){
            if (nums[0] == i || i == 0) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < sum / 2 + 1; j++){
                if (j < nums[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        //还是最后一个是否有值
        return dp[nums.length - 1][sum / 2];
    }
    @Test
    public void test(){
        int[] nums = {1,2,5};
        System.out.println(canPartition3(nums));
    }


}
