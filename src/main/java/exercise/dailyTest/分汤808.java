package exercise.dailyTest;

import org.junit.Test;

/*
有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
提供 100ml 的 汤A 和 0ml 的 汤B 。
提供 75ml 的 汤A 和 25ml 的 汤B 。
提供 50ml 的 汤A 和 50ml 的 汤B 。
提供 25ml 的 汤A 和 75ml 的 汤B 。
当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
注意 不存在先分配 100 ml 汤B 的操作。
需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 */
public class 分汤808 {
    //对是对了，但是又超出时间限制了 。
    public double soupServings(int n) {
        if (n == 0)return 0.5;
        return countRate(n, n);
    }
    public double countRate(int a, int b){
        double rate = 0;
        if (a - 100 <= 0){
            rate += 0.25;
        }else{
            rate += 0.25 * countRate(a - 100, b);
        }
        if (a - 75 <= 0 && b - 25 > 0){
            rate += 0.25;
        }else if (a - 75 <= 0 && b - 25 <= 0){
            rate += 0.125;
        }else if (a - 75 > 0 && b - 25 > 0){
            rate += 0.25 * countRate(a - 75, b - 25);
        }
        if (a - 50 <= 0 && b - 50 > 0){
            rate += 0.25;
        }else if (a - 50 <= 0 && b - 50 <= 0){
            rate += 0.125;
        }else if (a - 50 > 0 && b - 50 > 0){
            rate += 0.25 * countRate(a - 50, b - 50);
        }

        if (a - 25 <= 0 && b - 75 > 0){
            rate += 0.25;
        }else if (a - 25 <= 0 && b - 75 <= 0){
            rate += 0.125;
        }else if (a - 25 > 0 && b - 75 > 0){
            rate += 0.25 * countRate(a - 25, b - 75);
        }
        return rate;
    }
    @Test
    public void test(){
        System.out.println(soupServings(100));
    }

    public double soupServings2(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }
        return dp[n][n];
    }
}
