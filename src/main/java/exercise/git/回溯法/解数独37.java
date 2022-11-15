package exercise.git.回溯法;

import org.junit.Test;

/*
编写一个程序，通过填充空格来解决数独问题。
数独的解法需 遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class 解数独37 {
    public void solveSudoku(char[][] board) {
        dfs(0, 0, board);
    }
    private boolean dfs(int row, int col, char[][] board){
        if(row == board.length){
            return true;
        }
        //这里可以使用char类型来进行遍历
        for (char i = '1'; i <= '9'; i++){
            if (!isValid(row, col, i, board))continue;
            board[row][col] = i;
            int newRow = col == board[0].length - 1 ? row + 1 : row;
            int newCol = col == board[0].length - 1 ? 0 : col + 1;
            if (dfs(newRow, newCol, board))return true;
            board[row][col] = '.';
        }
        return false;

    }
    private boolean isValid(int row, int col, char cur, char[][] board){
        int newRow = row / 3 * 3;
        int newCol = col / 3 * 3;
        for (int i = newRow; i < newRow + 3; i++){
            for (int j = newCol; j < newCol + 3; j++){
                if (board[i][j] == cur) return false;
            }
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == cur) return false;
        }
        for (int j = 0; j < board[0].length; j++){
            if (board[row][j] == cur) return false;
        }
        return true;
    }

    @Test
    public void test(){
        int[] a = {1,2};
        System.out.println(a[0]);
        System.out.println(a[0]);
    }

}
