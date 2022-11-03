package exercise.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 删除字母匹配最长单词524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(findLongestWord(s, dictionary));
    }
    public static String findLongestWord(String s, List<String> dictionary) {
        String res = null;
        int maxLen = Integer.MIN_VALUE;
        for (String i : dictionary) {
            if(isContain(s,i) && i.length() > maxLen){
                maxLen = i.length();
                res = i;
            }
            if(isContain(s,i) && i.length() == maxLen){
                res = minDict(res, i);
            }
        }
        return res;
    }
    //判断是否可以通过缩减s来获得t
    public static boolean isContain(String s, String t){
        int sPoint = 0;
        int tPoint = 0;
        while(tPoint < t.length() && sPoint < s.length()){
            if (s.charAt(sPoint) != t.charAt(tPoint)){
                sPoint++;
            }else{
                sPoint++;
                tPoint++;
            }
        }
        if (tPoint == t.length()) return true;
        return false;
    }
    public static String minDict(String s, String t){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) < t.charAt(i)){
                return t;
            }else if (s.charAt(i) > t.charAt(i)){
                return s;
            }
        }
        return s;
    }
}
