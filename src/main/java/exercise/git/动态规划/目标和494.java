package exercise.git.动态规划;
/*
难度：中等

给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5

解释：
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。

提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 */

/**
 * a - b = 3
 * a + b = 5
 * a = 4;
 * 问题转换为，取部分元素和为k，不可重复选择，有多少种取法。
 */
public class 目标和494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        //目标值为负数和正数没区别。为了避免后面的转换，这里提前转换。
        sum += Math.abs(target);
        if (sum % 2 != 0) return 0;
        int k = sum / 2;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++){
            for (int j = k; j >= nums[i]; j--){
               dp[j] += dp[j - nums[i]];
            }
        }
        return dp[k];
    }
}
