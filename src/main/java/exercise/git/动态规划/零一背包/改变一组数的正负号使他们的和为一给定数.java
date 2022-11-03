package exercise.git.动态规划.零一背包;

import org.junit.Test;

import java.util.Arrays;

public class 改变一组数的正负号使他们的和为一给定数 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum - target)%2 != 0 || sum < target) {
            return 0;
        }
        int subSum = (sum - target)/2;
        int len = nums.length;
        int[][] dp = new int[len + 1][subSum + 1];
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < subSum + 1; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][subSum];
    }
    @Test
    public void test(){
        int[] nums = {1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
    }


    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
