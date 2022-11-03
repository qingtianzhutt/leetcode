package exercise.git.动态规划;

/**
 * 动态规划，题目可以转换为将石头转换为质量最相近的两堆，质量和相减就是最终的答案。
 */
/*
题目难度：中等

有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎； 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。

示例： 输入：[2,7,4,1,8,1] 输出：1 解释： 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]， 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]， 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]， 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。

提示：

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */
public class 最后一块石头的重量1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        //真的好
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }

    public int lastStoneWeightII2(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : stones){
            sum += i;
        }
        int space = sum / 2;
        int[][] dp = new int[stones.length][space + 1];
        for (int i = 0; i < stones.length; i++){
            for (int j = 0; j < space + 1; j++){
                if (i == 0){
                    dp[i][j] = j >= stones[0] ? stones[0] : 0;
                }else if (j < stones[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                }
            }
        }
        int res = sum - 2 * dp[stones.length - 1][space];
        return res;
    }
    //一次通过
    public int lastStoneWeightII3(int[] stones) {
        int sum = 0;
        for (int i : stones){
            sum += i;
        }
        int k = sum / 2;
        int[] dp = new int[k + 1];
        for (int i = 0; i < stones.length; i++){
            for (int j = k; j >= stones[i]; j--){
                if (j >= stones[i]){
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
        }
        return sum - 2 * dp[k];
    }
}