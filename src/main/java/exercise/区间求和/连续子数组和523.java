package exercise.区间求和;

import java.util.HashMap;
import java.util.Map;

public class 连续子数组和523 {
    public static void main(String[] args) {
        int[] nums = {23,2,6,4,7};
        System.out.println(checkSubarraySum(nums,13));
    }
    //只使用前缀和的方法，复杂夫太高
    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] nums2 = new int[nums.length + 1];
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i - 1];

        }
        for(int i = 1; i < nums2.length; i++){
            nums2[i] = nums[i - 1];
        }
        for(int i = 0; i < nums2.length; i++){
            for (int j = i + 2; j < nums2.length; j++){
                int value = nums2[j] - nums2[i];
                if(value%k == 0){
                    return true;
                }
            }
        }
        return false;
    }
    //使用前缀和+哈希表来解决问题
    public static boolean checkSubarraySum1(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //如果是复数，就重新搞
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
