package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。
示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
//剪枝
public class 组合总和三216 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;
    }
    private void dfs(int k, int n, int used){
        if (k == 0 && n == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        //k为0的去掉
        if (k == 0) {
            return;
        }
        for (int i = used; i <= 9 && i <= n; i++){
            path.add(i);
            dfs(k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum4(int k, int n) {
        dfs2(k, n, 1);
        return res;
    }
    private void dfs2(int k, int n, int index){
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (n == 0 || k == 0){
            return;
        }
        for (int i = index; i <= n && i <= 9; i++){
            path.add(i);
            dfs2(k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test(){
        int k = 3;
        int n = 7;
        System.out.println(combinationSum4(k, n));
    }
}
