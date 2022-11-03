package exercise.git.动态规划.斐波那契数列;

import org.junit.Test;

public class 强盗抢劫 {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int p1 = nums[0];
        if (nums.length == 1) return p1;
        int p2 = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return p2;
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            res = Math.max(p1 + nums[i], p2);
            p1 = p2;
            p2 = res;
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums = {1, 2, 3, 6, 3, 9};
        System.out.println(rob(nums));
    }
}
