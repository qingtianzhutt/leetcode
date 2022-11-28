package exercise.dayTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class 括号生成22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, new StringBuilder(), n, res);
        return res;
    }
    private void dfs(int l, int r, StringBuilder sb, int len, List<String> res){
        if (sb.length() == 2 * len || l == len){
            res.add(new String(sb));
            return;
        }
        if (l == r){
            String temp = sb.toString();
            sb.append("(");
            dfs(l + 1, r, sb, len, res);
            sb = new StringBuilder(temp);
        }
        if (l > r && l <= len){
            String temp = sb.toString();
            sb.append("(");
            dfs(l + 1, r, sb, len, res);
            sb = new StringBuilder(temp);
            sb.append(")");
            dfs(l, r + 1, sb, len, res);
            sb = new StringBuilder(temp);
        }
    }
    @Test
    public void test(){
        generateParenthesis(3);
    }
}
