package exercise.git.贪心算法;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
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
    //也算是一次通過
    public boolean canJump4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums[0];
        for (int i = 1; i <= len && i < nums.length; i++){
            len = Math.max(len, i + nums[i]);
        }
        return len >= nums.length - 1;
    }


}
