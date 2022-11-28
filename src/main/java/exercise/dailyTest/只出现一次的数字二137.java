package exercise.dailyTest;
/*
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 */
public class 只出现一次的数字二137 {
    //只适用于无符号整数，因为有符号的第32位代表的是负数。
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            if (count % 3 != 0) {
                //这个或等先运行。
                res |= 1 << i;
            }
        }
        return res;
    }
}
