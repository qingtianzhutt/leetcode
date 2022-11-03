package exercise.git.二分查找;

import org.junit.Test;

/**
 *  一次通过
 */
public class 移除元素27 {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    @Test
    public void test(){
        int[] nums = {3,2,2,3};
        int val = 3;
        int res = removeElementNew(nums, val);
        System.out.println(res);
    }
    public int removeElementNew(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }else {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
