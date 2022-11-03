package exercise.git.动态规划;
/*
题目难易：中等

给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200

示例 1: 输入: [1, 5, 11, 5] 输出: true 解释: 数组可以分割成 [1, 5, 5] 和 [11].

示例 2: 输入: [1, 2, 3, 5] 输出: false 解释: 数组不能分割成两个元素和相等的子集.

提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class 分割等和子集416 {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < n; i++){
            for(int j = target; j >= nums[i]; j--){
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    //又是一次通过，无敌
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums
             ) {
            sum += i;
        }
        if (sum % 2 != 0){
            return false;
        }
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < nums.length; i++){
            for (int j = sum / 2; j >= nums[i]; j--){
                if (j >= nums[i]){
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
        }
        return dp[sum / 2] == sum / 2;
    }

    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < sum / 2 + 1; i++){
            if (nums[0] == i || i == 0) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < sum / 2 + 1; j++){
                if (j < nums[i]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum / 2];
    }
}
