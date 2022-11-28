package exercise.dailyTest;

import lombok.experimental.var;
import org.junit.Test;

import java.util.*;

public class 子序列宽度之和891 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    //从结果上来看是对的，但是超出了时间和内存限制，系统可能会出一个很长的数组。
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        int res = 0;
        for (int i = 0; i < list.size(); i++){
//            Collections.sort(list.get(i));
            if (list.get(i).size() > 1){
                res += list.get(i).get(list.get(i).size() - 1) - list.get(i).get(0);
            }
        }
        return res;
    }
    private void dfs(int[] nums, int index){
        if (path != null && path.size() != 0){
            list.add(new ArrayList<>(path));
        }
        if (path.size() == nums.length)return;
        for (int i = index; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
    @Test
    public void test(){
        int[] nums = {2,1,3,4,5};
        System.out.println(sumSubseqWidths2(nums));
    }

    public int sumSubseqWidths2(int[] nums) {
        final int MOD = 1000000007;
        Arrays.sort(nums);
        long sum = 0;
        int[] temp = new int[nums.length];
        temp[0] = 1;
        for (int i = 1; i < nums.length; i++){
            //这边2的幂次肯定会超出，需要预处理。
            temp[i] = temp[i - 1] * 2 % MOD;
        }
        for (int i = 0; i < nums.length; i++){
            sum += (temp[i] - temp[nums.length - i - 1]) * nums[i];
        }
        return (int)sum;
    }
}
