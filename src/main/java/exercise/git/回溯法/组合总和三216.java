package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.List;
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
}
