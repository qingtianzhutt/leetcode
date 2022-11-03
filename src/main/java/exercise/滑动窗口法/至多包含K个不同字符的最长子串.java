package exercise.滑动窗口法;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s，找到至多包含K个不同字符的最长子串T。
 * subString 前闭后开
 */
public class 至多包含K个不同字符的最长子串 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String res = lengthOfLongestSubstringKDistinct(s);
        System.out.println(res);
    }
    public static String lengthOfLongestSubstringKDistinct(String s){
        Set<Character> set = new HashSet<>();
        int l = 0, lRes = 0;
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                if (len <= i - l + 1){
                    lRes = l;
                    len = i - l + 1;
                }
            }else{
                while(s.charAt(l) != s.charAt(i)){
                    l++;
                }
                l++;
            }
        }
        return s.substring(lRes, lRes + len);
    }
}
