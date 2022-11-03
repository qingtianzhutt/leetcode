package exercise.git.动态规划.矩阵路径;

import java.util.Arrays;

public class 矩阵的总路径数 {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] += res[j - 1];
            }
        }
        return res[n - 1];
    }
}
