package exercise.git.哈希表;

import java.util.*;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
    //hash法
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = i + j;
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(temp, list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(0 - nums[i])) {
                if (!map.get(0 - nums[i]).contains(i)) {
                    List<Integer> single = new ArrayList<>();
                    single.add(nums[i]);
                    for (int j : map.get(0 - nums[i])) {
                        single.add(nums[j]);
                    }
                }
            }
        }
        return res;
    }

    //双指针法
    //如果数字重复怎么办
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = 1, r = nums.length - 1;
            while(l < r){
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[r] == nums[r - 1])r--;
                    while(l < r && nums[l] == nums[l + 1])l++;
                    r--;
                    l++;

                }else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else if (nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }
            }
        }
        return res;
    }
}
