package exercise.git.双指针;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class 反转字符串中的元音字符 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while(l < r){
            if (!vowels.contains(chars[l])) {
                l++;
                continue;
            }
            if (!vowels.contains(chars[r])) {
                r--;
                continue;
            }
            swap(chars, l, r);
            l++;
            r--;
        }
        return new String(chars);
    }
    public void swap(char[] chars, int l, int r){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
    @Test
    public void test(){
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
