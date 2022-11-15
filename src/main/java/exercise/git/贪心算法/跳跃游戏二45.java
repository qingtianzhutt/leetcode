package exercise.git.贪心算法;

import org.junit.Test;

import java.util.Arrays;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明: 假设你总是可以到达数组的最后一个位置。
 */
public class 跳跃游戏二45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
    private int res = 0;
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        circle(nums, 0, 0);
        return res;
    }
    //能想到的通用的方法，常规做法。
    public void circle(int[] nums, int l, int r){
        if (r >= nums.length - 1){
            return;
        }
        res++;
        int newL = l + nums[l];
        int newR = r;
        for (int i = l; i <= r; i++){
            //找到最小的一个
            newL = Math.min(newL, i + nums[i]);
            newR = Math.max(newR, i + nums[i]);
        }
        newL = Math.min(newL, r + 1);
        circle(nums, newL, newR);
    }

    //使用动态规划
    public int jump4(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >=0; i--){
            int val = nums[i];
            //如果为0，那么直接置一个比较大的数，避免麻烦
            if (val == 0){
                dp[i] = 10000;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= val && i + j < nums.length; j++){
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }
        return dp[0];
    }


    @Test
    public void test(){
        int[] nums = {2,3,0,1,4};
        System.out.println(jump6(nums));
    }

    //暴力一次通过
    public int jump5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = 0;
        int res = 0;
        while (right < nums.length - 1){
            res++;
            int newRight = right;
            for (int i = left; i <= right; i++){
                newRight = Math.max(newRight, i + nums[i]);
                if (newRight >= nums.length - 1){
                    return res;
                }
            }
            left = right + 1;
            right = newRight;
        }
        return 0;
    }
    //动态规划，从后往前
    public int jump6(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] != 0){
                for (int j = i + 1; j <= nums.length - 1 && j <= i + nums[i]; j++){
                    //这里注意 删选语句不能卸载for循环的判断中啊。
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[0];
    }
}
