package exercise.git.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例:
输入: n = 4, k = 2
输出:
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]
 */
public class 组合77 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //这里n-(k - path.size()) + 1,是为剪枝。
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, res, path);
        return res;
    }
    private void dfs(int n, int k, int target, List<List<Integer>> res, List<Integer> path){
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = target; i <= n ; i++) {
            path.add(i);
            dfs(n, k, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }


    public List<List<Integer>> combine3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs2(n, k, 1, res, path);
        return res;
    }
    public void dfs2(int n, int k, int index, List<List<Integer>> res, List<Integer> path){
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            dfs2(n, k - 1, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }
}
