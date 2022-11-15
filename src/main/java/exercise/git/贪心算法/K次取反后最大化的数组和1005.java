package exercise.git.贪心算法;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
以这种方式修改数组后，返回数组可能的最大和。
输入：A = [4,2,3], K = 1
输出：5
解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
输入：A = [3,-1,0,2], K = 3
输出：6
解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
输入：A = [2,-3,-1,5,-4], K = 2
输出：13
解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 */
//思路：
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
        //修改原数组。
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
    public int largestSumAfterKNegations3(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        Arrays.sort(nums);
        int count = 0;
        for (int i : nums){
            if (i < 0)count++;
        }
        int res = 0;
        if (K <= count){
            for (int i = 0; i < nums.length; i++){
                if (K > 0){
                    res -= nums[i];
                    K--;
                }else{
                    res += nums[i];
                }
            }
        }else if ((K - count) % 2 == 0){
            for (int i : nums){
                res += i;
            }
        }else {
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();
            for (int i : nums){
                res += i;
            }
            res -= 2 * nums[0];
        }
        return res;
    }

}
