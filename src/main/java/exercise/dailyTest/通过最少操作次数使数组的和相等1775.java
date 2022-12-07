package exercise.dailyTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 */

//shit
public class 通过最少操作次数使数组的和相等1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int max = nums1.length * 6;
        int sum2 = Arrays.stream(nums2).sum();
        if (sum2 < sum1 || sum2 > max){
            return -1;
        }else if (sum2 == sum1){
            return 0;
        }else {
            List<Integer> collect = Arrays.stream(nums1).map(e -> 6 - e).sorted().boxed().collect(Collectors.toList());
            int res = 0;
            int sub = sum2 - sum1;
            for (int i = collect.size() - 1; i >= 0; i--) {
                res++;
                if (sub - collect.get(i) <= 0){
                    break;
                }
                sub -= collect.get(i);
            }
            return res;
        }
    }
}
