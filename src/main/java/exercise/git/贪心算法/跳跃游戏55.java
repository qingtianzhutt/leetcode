package exercise.git.贪心算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 跳跃游戏55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
    //超出时间限制了。
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if (node + nums[node] >= nums.length - 1){
                return true;
            }
            int val = nums[node];
            while(val > 0){
                queue.add(node + val--);
            }
        }
        return false;
    }
    //标准答案
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int limit = 0;
        for (int i = 0; i < nums.length && i <= limit; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            limit = Math.max(limit, i + nums[i]);
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump2(nums));
    }


}
