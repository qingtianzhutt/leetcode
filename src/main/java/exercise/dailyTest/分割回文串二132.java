package exercise.dailyTest;

import java.util.*;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
返回符合要求的 最少分割次数 。
 */
public class 分割回文串二132 {
    private List<List<String>> res = new ArrayList<>();
    private Deque<String> path = new LinkedList<>();
    //这种垃圾的方法   会超出时间限制。
    public int minCut(String s) {
        dfs(s, 0);
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++){
            len = Math.min(len, res.get(i).size());
        }
        return len - 1;
    }
    private void dfs(String s, int index){
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++){
            String substring = s.substring(index, i);
            if (isSame(substring)){
                path.add(substring);
                dfs(s, i);
                path.removeLast();
            }
        }

    }
    private boolean isSame(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }








    //很巧妙的方法。
    public int minCut2(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }
        //这个是动态规划  先对数据进行预处理。  也可以用来统计回文子串的数量啊 。
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    //如果是回文子串。
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }
}
