package exercise.git.动态规划;
/*
我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。

现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。

以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 */
//就是在求最长公共子序列
public class 不相交的线1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int [][] dp = new int[A.length+1][B.length+1];
        for(int i=1;i<=A.length;i++) {
            for(int j=1;j<=B.length;j++) {
                if (A[i-1]==B[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
