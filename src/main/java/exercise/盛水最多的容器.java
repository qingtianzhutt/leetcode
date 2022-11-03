package exercise;

/**
 * easy
 *双指针的用法
 * 每次移动较小的那个指针并且统计容积，不断更新最大的容积。
 *
 */
public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int res = countBigVolume(nums);
        System.out.println(res);
    }
    public static int countBigVolume(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        int res = 0;
        while(l < r){
             int high = Math.min(nums[l],nums[r]);
             res = Math.max(res, (r - l) * high);
             if (l < r){
                 l++;
             }else{
                 r--;
             }
        }
        return res;
    }

}
