package exercise;

public class test {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++){
                if(dp[i + j] != 0){
                    dp[i + j] = Math.min(dp[i + j] , dp[i] + 1);
                }else{
                    dp[i + j] = dp[i] + 1;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
