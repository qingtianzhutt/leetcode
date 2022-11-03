package exercise.git.动态规划;
/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

示例 1：

输入："abc" 输出：3 解释：三个回文子串: "a", "b", "c"

示例 2：

输入："aaa" 输出：6 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

提示：

输入的字符串长度不会超过 1000 。
 */
public class 回文子串647 {
    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //当两端字母一样时，才可以两端收缩进一步判断
                if (s.charAt(i) == s.charAt(j)) {
                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //否则通过收缩之后的字串判断
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {//两端字符不一样，不是回文串
                    dp[i][j] = false;
                }
            }
        }
        //遍历每一个字串，统计回文串个数
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (i == j){
                    dp[i][j] = true;
                    res++;
                }else if (s.charAt(i) == s.charAt(j)){
                    if (j - i < 2){
                        dp[i][j] = true;
                        res++;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j])res++;
                    }
                }
            }
        }
        return res;
    }
    //双指针法
    public int countSubstrings3(String s) {
        int res = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++){
            int m = i, n = i;
            while(m >= 0 && n < s.length() * 2 - 1){
                if (s.charAt(m) == s.charAt(n)){
                    res++;
                }
                m--;
                n++;
            }
        }
        return res;
    }

}
