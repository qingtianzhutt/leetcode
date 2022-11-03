package exercise.git.单调栈;

import java.util.TreeMap;
//TreeMap记载每个数及其小于它的所有数的最小下标： 在更新的时候，只需要在有序哈希表中找到，不大于当前数字的最大数字，其对应的值就是最小的下标
public class 最大宽度坡 {
    public int maxWidthRamp(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(-1,nums.length);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int a=map.floorKey(nums[i]);
            ans=Math.max(ans,i-map.get(a));
            if(!map.containsKey(nums[i])){map.put(nums[i],i);}
            map.put(nums[i],Math.min(map.get(a),map.get(nums[i])));
        }
        return ans;
    }
}
