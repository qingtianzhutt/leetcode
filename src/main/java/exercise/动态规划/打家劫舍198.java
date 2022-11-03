package exercise.动态规划;

public class 打家劫舍198 {
    public static void main(String[] args) {

    }
    //写的看起来太过复杂了，最简单的理解来写的。
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0],nums[1]);
        if(nums.length == 3)return Math.max(nums[0] + nums[2],nums[1]);
        int p = nums[0];
        int q = nums[1];
        int r = nums[0] + nums[2];
        int temp;

        int len = nums.length;
        int k = 3;
        while(k < len){
            temp = Math.max(p, q) + nums[k];
            p = q;
            q = r;
            r = temp;
            k++;
        }
        p = nums[0];
        q = nums[1];
        int t = nums[0] + nums[2];
        k = 3;
        while(k < len - 1){
            temp = Math.max(p, q) + nums[k];
            p = q;
            q = t;
            t = temp;
            k++;
        }

        return Math.max(t,r);
    }
    //滚动数组法，dp[0]和dp[1] 分别是记录的前n个房间最大的获利。
    public static int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp[1];
        int temp = 0;
        for(int i = 2; i < nums.length; i++){
            temp = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return temp;
    }

    public static int rob二(int[] nums) {
        return 1;
    }
}
