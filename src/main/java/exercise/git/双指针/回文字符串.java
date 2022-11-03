package exercise.git.双指针;

public class 回文字符串 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }else{
                return isHuiwen(s, l + 1, r) || isHuiwen(s, l, r - 1);
            }
        }
        return true;
    }
    public boolean isHuiwen(String s, int l, int r) {
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
