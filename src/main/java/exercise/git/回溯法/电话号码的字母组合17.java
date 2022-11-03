package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//理解本题后，要解决如下三个问题：
//
//1、数字和字母如何映射
//2、两个字母就两个for循环，三个字符我就三个for循环，以此类推，然后发现代码根本写不出来
//3、输入1 * #按键等等异常情况
//算是自己搞定了
public class 电话号码的字母组合17 {
    private String[] map ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder("");
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0);
        return res;
    }
    private void dfs(String digits, int target){
        if (target == digits.length()) {
            res.add(path.toString());
            return;
        }
        int numericValue = Character.getNumericValue(digits.charAt(target));
        String s = map[numericValue];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            dfs(digits, target + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    @Test
    public void test(){
        String s = "223";
        System.out.println(letterCombinations(s));
    }
}
