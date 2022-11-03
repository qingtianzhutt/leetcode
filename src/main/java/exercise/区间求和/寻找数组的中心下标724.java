package exercise.区间求和;

public class 寻找数组的中心下标724 {
    public static void main(String[] args) {
        int[] input = {1,7,3,6,5,6};
        System.out.println(1);
        System.out.println(pivotIndex(input));
    }
    public static int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int[] nums1 = new int[nums.length];
        nums1[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums1[i] = nums1[i - 1] + nums[i];
        }
        int[] nums2 = new int[nums.length];
        nums2[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            nums2[i] = nums2[i + 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums1[i] == nums2[i]){
                return i;
            }
        }
        return -1;

    }
}
