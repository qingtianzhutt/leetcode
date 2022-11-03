package exercise.git.动态规划;
//
public class 爬楼梯进阶70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1,2};
        dp[0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i >= weight[j]) dp[i] += dp[i - weight[j]];
            }
        }

        return dp[n];
    }
}
