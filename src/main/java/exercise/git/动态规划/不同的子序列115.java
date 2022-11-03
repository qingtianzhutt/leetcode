package exercise.git.动态规划;

import org.junit.Test;

/*
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

题目数据保证答案符合 32 位带符号整数范围。
 */
public class 不同的子序列115 {
    private int count = 0;
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
    //时间太长了
    public int numDistinct2(String s, String t) {
        circle(0, 0, s, t);
        return count;
    }
    public void circle(int index1, int index2, String s, String t){
        if (index1 >= s.length()){
            count++;
            return;
        }else if (index2 >= t.length()){
            return;
        }
        for (int i = index2; i < t.length(); i++){
            if (s.charAt(index1) == t.charAt(i)){
                circle(index1 + 1, i + 1, s, t);
            }
        }
    }
    //动态规划手写
    //s中t出现的次数。
    public int numDistinct3(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        //最好先模拟下
        for (int i = 0; i < s.length() + 1; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++){
            for (int j = 1; j < s.length() + 1; j++){
                if (t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
    @Test
    public void test(){
        String s = "bag";
        String t = "babgbag";
        System.out.println(numDistinct2(s, t));
    }
}
