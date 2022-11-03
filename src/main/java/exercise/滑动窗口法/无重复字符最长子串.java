package exercise.滑动窗口法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符最长子串 {
    public static void main(String[] args) {
        String s = "abcddabcbbcdaf";
        int t = lengthOfLongestSubstringNewMap(s);
        System.out.println(t);
    }
    //滑动窗口法（使用经典方法）
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int l = 0;
        int len = 0;
        int lenNow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                lenNow = i - l + 1;
            }else{
                while(s.charAt(l) != s.charAt(i)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l += 1;
                lenNow = i - l + 1;
            }
            len = Math.max(len, lenNow);
        }
        return len;
    }
    //使用map来存储，可以降低很多复杂度。  这题记录l坐标的位置就可以直接将字符打印出来。
    public static int lengthOfLongestSubstring1(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //这一步，精妙，不用将map中的数拿出来了

                l = Math.max(l, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i - l + 1);
        }
        return len;
    }
    //通过map来做。
    public static int lengthOfLongestSubstringNewMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < s.length()){
            if (map.containsKey(s.charAt(r))) {
                int newL = map.get(s.charAt(r)) + 1;
                for (int i = l; i < newL; i++) {
                    map.remove(s.charAt(i));
                }
                l = newL;
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
    //我真是恐怖如斯，一次通过，而且优化了一些代码逻辑,通过set来进行操作
    public static int lengthOfLongestSubstringNewSet(String s){
        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }







}
