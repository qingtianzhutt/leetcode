package exercise.git.动态规划.斐波那契数列;

public class 强盗在环形街区抢劫 {
    //计算偷最后一间房间以及不偷最后一间房间的收获,偷最后一间房间的取值范围为[1,n-1],不偷最后一件房间取值范围为[0,n-2]
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp1 = nums[0], dp2 = Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(dp2, nums[2]);
        int res1 = dp2;
        for (int i = 2; i < nums.length - 1; i++) {
            res1 = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = res1;
        }
        dp1 = nums[1];
        dp2 = Math.max(nums[1], nums[2]);
        int res2 = dp2;
        for (int j = 3; j < nums.length; j++) {
            res2 = Math.max(dp1 + nums[j], dp2);
            dp1 = dp2;
            dp2 = res2;
        }
        return Math.max(res1, res2);
    }
}
