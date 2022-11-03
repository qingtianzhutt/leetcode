package exercise.git.动态规划;

public class 最大矩形85 {
    public int maximalRectangle(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0 || dp[i - 1][j - 1] == 0 || matrix[i][j] == '0'){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }else{
                    boolean flag = true;
                    for (int m = 0; m < i; m++){
                        if (matrix[m][j] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    for (int n = 0; n < j; n++){
                        if (matrix[i][n] == '0'){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        dp[i][j] = dp[i - 1][j - 1] + i + j;
                    }else{
                        dp[i][j] = 1;
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
