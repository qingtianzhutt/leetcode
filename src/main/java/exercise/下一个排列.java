package exercise;

import java.util.*;

/**
 *  顾名思义，题目不介绍了。
 *  *  重点在于Arrays.sort(nums,fromindex,toindex)这个数组的部分倒序方法的使用 。
 */

public class 下一个排列 {
    public static void main(String[] args) {
        int[] input = {9,8,7,6,5,4,3,2,1};
        nextPermutation(input);
        for (int i : input){
            System.out.println(i);
        }
    }
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int len = nums.length - 1;
        int reverse = len;
        //此时nums[reverse] > nums[reverse]还有可能reverse为0。
        while(reverse > 0 && nums[reverse] < nums[reverse - 1]){
            reverse--;
        }
        if (reverse == len){
            swap(reverse,reverse - 1, nums);
            return;
        }
        if (reverse == 0){
            Arrays.sort(nums,0,nums.length);
            return;
        }

        for (int i = len; i >= reverse; i--){
            if (nums[i] > nums[reverse - 1]){
                int big = i;
                swap(big,reverse - 1,nums);
                break;
            }
        }
        //反转reverse后面的数字
        Arrays.sort(nums,reverse,nums.length);

    }
    public static void swap(int i, int j, int[] nums){
        int mid = nums[i];
        nums[i] = nums[j];
        nums[j] = mid;
    }
}
