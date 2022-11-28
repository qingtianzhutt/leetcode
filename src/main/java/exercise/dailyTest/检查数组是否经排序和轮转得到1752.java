package exercise.dailyTest;
/*
给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
源数组中可能存在 重复项 。
注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 */
public class 检查数组是否经排序和轮转得到1752 {
    public boolean check(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int end = -1;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]){
                end = i;
                break;
            }
        }
        if (end == -1) return true;
        for (int i = 0; i < end; i++){
            if (nums[i] > nums[i + 1]) return false;
        }
        for (int i = end + 1; i < nums.length - 1; i++){
            if (nums[i] > nums[i + 1]) return false;
        }
        if (nums[nums.length - 1] > nums[0]) return false;
        return true;
    }
}
