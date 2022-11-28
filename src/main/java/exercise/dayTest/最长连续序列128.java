package exercise.dayTest;
import java.util.HashSet;
import java.util.Set;
/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 1;
        for (Integer num : set) {
            int curLen = 1;
            if (!set.contains(num - 1)){
                int cursum = num;
                while(set.contains(cursum + 1)){
                    cursum++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
