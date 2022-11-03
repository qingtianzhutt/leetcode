package exercise.滑动窗口法;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String res = minWindow(s, t);
        System.out.println(res);
    }
    public static String minWindow(String s, String t){
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int lRes = 0;
        int len = Integer.MAX_VALUE;
        int sLen = s.length();
        while(r < sLen){
            if (tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while(check(sMap, tMap)){
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    lRes = l;
                }
                if (tMap.containsKey(s.charAt(l))) {
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                }
                l++;
            }
            r++;
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(lRes, lRes + len);

    }
    public static boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        Iterator<Character> iterator = tMap.keySet().iterator();
        while(iterator.hasNext()){
            Character next = iterator.next();
            if (!sMap.containsKey(next) || sMap.get(next) < tMap.get(next)){
                return false;
            }
        }
        return true;

    }
}
