package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *还是双指针法。
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] a = {-9,-3,-1,0,-8,2,3,6,7,10,1};
        threeSum(a);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)return null;
        Arrays.sort(nums);
        int cur = 1;
        int l = 0;
        int r = 2;
        while(cur < nums.length - 1){
            if(nums[cur] + nums[l] + nums[r] == 0){
                res.add(Arrays.asList(nums[cur], nums[r], nums[l]));
                if(l > 0){
                    l--;
                    continue;
                }
                if(r < nums.length - 1){
                    r++;
                }
            }else if(nums[cur] + nums[l] + nums[r] < 0){
                if (r == nums.length - 1){
                    cur++;
                    l = cur - 1;
                    r = cur + 1;
                    continue;
                }
                r++;
                while(r < nums.length && nums[r] == nums[r - 1]){
                    if(r == nums.length - 1){
                        cur++;
                        l = cur - 1;
                        r = cur + 1;
                        break;
                    }
                    r++;
                }
            }else if(nums[cur] + nums[l] + nums[r] > 0){
                if(l == 0){
                    cur++;
                    l = cur - 1;
                    r = cur + 1;
                    continue;
                }
                l--;
                while(l >= 0 && nums[l] == nums[l + 1]){
                    if(l == 0){
                        cur++;
                        l = cur - 1;
                        r = cur + 1;
                        break;
                    }
                    l--;
                }
            }
        }
        return res;

    }
}
