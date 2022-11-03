package exercise.git.动态规划.数组区间;
//前缀和
public class 数组区间和 {
    private int[] nums;
    public 数组区间和(int[] nums) {
        this.nums = new int[nums.length];
        this.nums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] = this.nums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? nums[right] : nums[right] - nums[left - 1];
    }
}
