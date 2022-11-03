package exercise.git.动态规划.分隔整数;

import org.junit.Test;

public class 分隔整数构成字母字符串 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.contains("0"))return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 2) < '2' && s.charAt(i - 2) > 0 || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
    @Test
    public void test(){
        String s = "06";
        System.out.println(s.contains("0"));
    }
}
