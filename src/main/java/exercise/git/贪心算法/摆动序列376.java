package exercise.git.贪心算法;

import org.junit.Test;
//不会做，真尼玛难
public class 摆动序列376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null)return 0;
        if (nums.length <= 2) {
            return nums.length;
        }
        int res = 2;
        int cur = nums[0] - nums[1];
        for (int i = 1; i < nums.length - 1; i++){
            int temp = nums[i] - nums[i + 1];
            if (cur * temp < 0){
                cur = -cur;
                res++;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[] nums = {};
        int i = wiggleMaxLength(nums);
        System.out.println(i);
    }
}
