package exercise.dailyTest;
/*
如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
字母和数字都属于字母数字字符。
给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class 验证回文串125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()){
            //if (Character.isLetterOrDigit(c)),这种方法真是好。
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }

        }
        //StringBuffer sgood_rev = new StringBuffer(sgood).reverse(); 也可以直接翻转，然后直接进行对比。
        int l = 0, r = sb.length() - 1;
        while(l < r){
            if (sb.charAt(l) != sb.charAt(r) && Character.toUpperCase(sb.charAt(l)) != Character.toUpperCase(sb.charAt(r))) return false;
            l++;
            r--;
        }
        return true;

    }
}
