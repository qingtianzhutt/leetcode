package exercise.dayTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
//直接动态规划
public class 最长有效括号32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] array = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++){
            if (array[i] == '('){
                dp[i] = 0;
            }else{
                if (array[i - 1] == '('){
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                }else if (i - dp[i - 1] > 0 && array[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
        }
        int res = Arrays.stream(dp).max().getAsInt();
        return res;
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses3(String s) {
        int[] dp = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '('){
                dp[i] = 1;
                dp[stack.peek()] = 1;
                stack.pop();
            }else if (s.charAt(i) == '('){
                stack.push(i);
            }
        }
        int res = 0;
        int curLen = 0;
        for (int i = 0; i < dp.length; i++){
            if(dp[i] == 1){
                curLen++;
                res = Math.max(res, curLen);
            }else{
                curLen = 0;
            }
        }
        return res;
    }





    @Test
    public void test(){
        String s = "(())())()()((())))";
        System.out.println(longestValidParentheses3(s));

    }
}
