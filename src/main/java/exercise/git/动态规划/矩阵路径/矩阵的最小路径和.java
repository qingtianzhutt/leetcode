package exercise.git.动态规划.矩阵路径;

//一遍做出来，现在牛逼了
public class 矩阵的最小路径和 {
    public int minPathSum(int[][] grid) {
        for (int j = 1; j < grid[0].length; j++){
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = i; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
