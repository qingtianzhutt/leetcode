package exercise.git;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 高速缓存 {
    int res = Integer.MAX_VALUE;
    @Test
    public void test(){
        int size = 2;
        int[] nums = {1,2,3,1,2,3};
        Set<Integer> set = new HashSet<>();
        dfs(set, nums, 0, 0, size);
        System.out.println(res);
    }
    public void dfs(Set<Integer> set, int[] nums, int index, int count,int size){
        if (index == nums.length){
            res = Math.min(res, count);
            return;
        }
        for (int i = index; i < nums.length; i++){
            if (set.isEmpty() || (!set.contains(nums[i]) && set.size() < size)){
                set.add(nums[i]);
                count++;
            }else if (!set.contains(nums[i])){
                for (int single : set){
                    set.remove(single);
                    set.add(nums[i]);
                    dfs(set, nums, i + 1, count + 1, size);
                    set.remove(nums[i]);
                    set.add(single);
                }
            }
        }
    }
}
