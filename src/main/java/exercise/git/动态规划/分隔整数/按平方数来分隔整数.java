package exercise.git.动态规划.分隔整数;

public class 按平方数来分隔整数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
//            if (isSqrt(i)){
//                dp[i] = 1;
//                continue;
//            }
            int leastNum = Integer.MAX_VALUE;
            for (int j = 1; j <= i/2; j++) {
                leastNum = Math.min(leastNum, dp[j] + dp[i - j]);
            }
            dp[i] = leastNum;
        }
        return dp[n];
    }
//    public boolean isSqrt(int n){
//        int s = (int)Math.sqrt(n);
//        if (s * s == n){
//            return true;
//        }
//        return false;
//    }
}
