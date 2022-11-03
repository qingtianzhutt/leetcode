package exercise.git.贪心算法;

import java.util.Arrays;
import java.util.stream.IntStream;

public class K次取反后最大化的数组和1005 {
    public int largestSumAfterKNegations(int[] nums, int K) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < K && i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            } else{
                nums[i] = -nums[i];
                count++;
            }
        }
        if (count < K ) {
            int left = K - count;
            if (left % 2 != 0) {
                if (count == nums.length || (count > 0 && nums[count - 1] < nums[count])) {
                    nums[count - 1] = -nums[count - 1];
                } else {
                    nums[count] = -nums[count];
                }
            }
        }
        int res = 0;
        for(int i : nums){
            res += i;
        }
        return res;
    }
    //教程中的好方法。
    public int largestSumAfterKNegations2(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }
}
