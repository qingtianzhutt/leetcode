package exercise.git.贪心算法;

import org.junit.Test;
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i] <= 10 ^ 4
 */
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

    public int maxProfit4(int[] prices) {
        // [天数][是否持有股票]
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

    //动态规划
    public int maxProfit5(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];
        //0表示买入，1表示卖出
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }






    @Test
    public void test(){
        int[] nums = {6,1,3,2,4,7};
        System.out.println(maxProfit2(nums));
    }
}
