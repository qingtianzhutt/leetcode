package exercise.git.回溯法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
//调试几把通过
public class 分隔回文串131 {
    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }

    private void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> partition2(String s) {
        dfs(s, 0);
        return lists;
    }
    private void dfs(String s, int start){
        if (start >= s.length()){
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if (isPalindrome1(temp)) {
                deque.add(temp);
                dfs(s, i + 1);
                deque.removeLast();
            }
        }
    }
    //从start开始找回文子串。
    private void dfs3(String s, int start){
        if (start >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        //这里的i指的是能被截取的最长大小，所以可以为s.length()
        for (int i = start + 1; i <= s.length(); i++){
            String temp = s.substring(start, i);
            if (isPalindrome1(temp)) {
                deque.add(temp);
                dfs3(s, i);
                deque.removeLast();
            }
        }
    }

    private boolean isPalindrome1(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test(){
        String s = "aab";
        List<List<String>> lists = partition2(s);
        System.out.println(lists);
    }
}
