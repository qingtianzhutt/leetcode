package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种对于没有重复的数字的处理。
 */
public class 组合总和 {
    public static void main(String[] args) {
        int[] a = {2,3,7};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(a, res, combine,0,10);
        System.out.println(res);
    }

    public static void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combine, int place, int target){
        if(target == 0){
            //这里一定要new 一个新的arrayList，不然就是把combine的引用传递到结果中去了，结果会一直改变。
            res.add(new ArrayList<>(combine));
            return;
        }
        for(int i = place; i < candidates.length; i++){
            if (target < candidates[i]){
                return;
            }else{
                combine.add(candidates[i]);
                dfs(candidates,res,combine,i ,target - candidates[i]);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
