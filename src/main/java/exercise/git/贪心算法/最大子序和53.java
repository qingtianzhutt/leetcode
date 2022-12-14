package exercise.git.贪心算法;

import org.junit.Test;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例: 输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 最大子序和53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //一次通過。
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (curSum > 0) {
                curSum += nums[i];
            }else {
                curSum = nums[i];
            }
            res = Math.max(curSum, res);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }

}
