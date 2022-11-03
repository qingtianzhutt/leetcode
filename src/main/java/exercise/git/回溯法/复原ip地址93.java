package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
//真的牛逼，一次通过
public class 复原ip地址93 {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder ip = new StringBuilder("");
        dfs(s, ip, 0, 0);
        return res;
    }
    private void dfs(String s, StringBuilder ip, int start, int count){
        if (count == 4 && start == s.length()) {
            res.add(new String(ip));
            return;
        }
        if (count == 4 || start == s.length())return;
        for (int i = start; i < s.length(); i++) {
            if(i - start > 2)break;
            //如果是0开始，那么只有一种可能，不需要for循环。
            if (i == start && s.charAt(i) == '0') {
                if (count != 0)ip.append(".");
                ip.append('0');
                dfs(s, ip, i + 1, count + 1);
                return;
            }
            String temp = s.substring(start, i + 1);
            if (Integer.valueOf(temp) <= 255){
                int l = ip.length();
                if (count != 0){
                    ip.append('.');
                }
                ip.append(temp);
                dfs(s, ip, i + 1, count + 1);
                //这里是复原stringbuilder的。
                ip.delete(l, ip.length());
            }
        }
    }

    @Test
    public void test(){
        String s = "101023";
        List<String> strings = restoreIpAddresses(s);
        System.out.println(strings);

    }
}
