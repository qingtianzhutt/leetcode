package exercise.git.贪心算法;

import org.junit.Test;

public class 买卖股票的最佳时机II122 {
    //贪心算法
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
    //l代表峰底，r代表峰顶，完全按照实际情况进行模拟。
    public int maxProfit2(int[] prices) {
        int l = 0, r = 0;
        int res = 0;
        boolean mark = false;
        for (int i = 0; i < prices.length - 1; i++){
            //l此时是最小了
            if (prices[i + 1] <= prices[i]){
                if (mark)res += prices[r] - prices[l];
                l = i + 1;
                mark = false;
            } else{
                r = i + 1;
                mark = true;
            }
        }
        if (mark){
            res += prices[r] - prices[l];
        }
        return res;
    }
    //动态规划
    public int maxProfit3(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //昨天持有和昨天不持有。
            dp[i][0] = Math.max(dp[i - 1][0], prices[i - 1]  + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }



    @Test
    public void test(){
        int[] nums = {6,1,3,2,4,7};
        System.out.println(maxProfit2(nums));
    }
}
