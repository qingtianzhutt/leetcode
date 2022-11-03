package exercise.git.动态规划.分隔整数;

import org.junit.Test;

public class 分隔整数的最大乘积 {
    //贪心算法，用数学的方法证明
    public int integerBreak(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int count3 = 0, count2 = 0;
        while(n - 3 >= 2 || n - 3 == 0){
            n -= 3;
            count3++;
        }
        while(n - 2 >= 0){
            n -= 2;
            count2++;
        }
        int res = 1;
        while(count3-- > 0){
            res *= 3;
        }
        while(count2-- > 0){
            res *= 2;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(integerBreak(8));
    }
    //用数学规划的方法证明，用到的空间复杂度较高
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++){
                curMax = Math.max(curMax, (Math.max(j * (i - j), j * dp[i - j])));
            }
            dp[i] = curMax;
        }
        return dp[n];

    }
}
