package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
输入：s = "0000"
输出：["0.0.0.0"]
输入：s = "1111"
输出：["1.1.1.1"]
 */
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
        List<String> strings = restoreIpAddresses2(s);
        System.out.println(strings);
        String t = "01";
        System.out.println(t.charAt(0) == '0');
        System.out.println(Integer.parseInt(t) > 255);

    }


    public List<String> restoreIpAddresses2(String s) {
        StringBuilder ip = new StringBuilder("");
        dfs2(s, ip, 0, 0);
        return res;
    }
    private void dfs2(String s, StringBuilder ip, int start, int count){
        if (start == s.length() && count == 4){
            res.add(new String(ip));
            return;
        }
        if (count == 4 || start >= s.length())return;
        for (int i = start + 1; i <= s.length(); i++){
            String temp = s.substring(start, i);
            if (isValid(temp)) {
                String tempIp = ip.toString();
                ip.append(temp);
                if (count <= 2)ip.append(".");
                dfs2(s, ip, i, count + 1);
                ip = new StringBuilder(tempIp);
            }
        }
    }
    //注意s.charAt(0)   和s.indexOf('0')的区别。
    private boolean isValid(String s){
        if (s.charAt(0) == '0' && s.length() != 1)return false;
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }

}
