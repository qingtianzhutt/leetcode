package exercise.git.二分查找;

import org.junit.Test;

public class 二分 {
    @Test
    public void test(){

    }
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
    //一出手就是一模一样
    public int searchNew(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (target > nums[mid]){
                l = mid + 1;
            }else if (target < nums[mid]){
                r = mid - 1;
            }
        }
        return -1;
    }
}
