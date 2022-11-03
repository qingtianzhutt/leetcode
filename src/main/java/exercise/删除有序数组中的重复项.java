package exercise;

import java.util.Arrays;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(input));
//        System.out.println(removeDuplicates2(input));
        System.out.println(Arrays.toString(input));

    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        if (nums.length == 1) return 1;
        int l = 0, r = l + 1;
        while(r < nums.length){
            if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
                r++;
            }else{
                r++;
            }
        }
        return l + 1;
    }
    //删除有序数组中的重复项2，每个元素最多出现两次。
    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if (nums.length == 1)return 1;
        int l = 0, r = l + 1;
        int times = 1;
        while(r < nums.length){
            if(nums[l] != nums[r]){
                times = 1;
                l++;
                nums[l] = nums[r];
                r++;
            }else{
                if(times == 1){
                    l++;
                    nums[l] = nums[r];
                }
                times++;
                r++;
            }
        }
        return l + 1;
    }

}
