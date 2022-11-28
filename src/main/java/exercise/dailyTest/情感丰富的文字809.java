package exercise.dailyTest;

import org.junit.Test;

/*
有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
输入一组查询单词，输出其中可扩张的单词数量。
 */
public class 情感丰富的文字809 {
    //重在考量   循环的使用。
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++){
            if (express(s, words[i]))res++;
        }
        return res;
    }
    public boolean express(String s, String t){
        int l = 0, r = 0;
        while(l < s.length() && r < t.length()){
            if (s.charAt(l) == t.charAt(r)){
                l++;
                r++;
            }else {
                if (l == 0 || s.charAt(l) != s.charAt(l - 1))return false;
                int countSame = 1;
                int temp = l;
                while(l < s.length()){
                    if (s.charAt(l) == s.charAt(l - 1)){
                        countSame++;
                        l++;
                    }else{
                        break;
                    }
                }
                while(temp > 0){
                    if (s.charAt(temp) == s.charAt(temp - 1)){
                        countSame++;
                        temp--;
                    }else{
                        break;
                    }
                }
                if (countSame - 1 < 3) return false;
            }
        }
        if (l == s.length() && r == t.length()) return true;
        if (l == s.length()) return false;
        int countSame = 1;
        int temp = l;
        while(l < s.length()){
            if (s.charAt(l) == s.charAt(l - 1)){
                countSame++;
                l++;
            }else{
                break;
            }
        }
        while(temp > 0){
            if (s.charAt(temp) == s.charAt(temp - 1)){
                countSame++;
                temp--;
            }else{
                break;
            }
        }
        if (countSame - 1 < 3 || l < s.length()) return false;
        return true;
    }
    @Test
    public void test(){
        String s = "dddiiiinnssssssoooo";
        String[] words = {"ddiinnso"};
        System.out.println(expressiveWords(s, words));
    }
    //第二种思路，就是见到相同的先往后移动，计算相同的数目,算是一次通过了。
    public boolean express2(String s, String t){
        int l = 0, r = 0;
        while(l < s.length() && r < t.length()){
            if (s.charAt(l) != t.charAt(r)) return false;
            int lLen = 1, rLen = 1;
            while(l < s.length() - 1){
                if (s.charAt(l) == s.charAt(l + 1)){
                    lLen++;
                    l++;
                }else{
                    break;
                }
            }
            while(r < t.length() - 1){
                if (t.charAt(r) == t.charAt(r + 1)){
                    rLen++;
                    r++;
                }else {
                    break;
                }
            }
            if (rLen > lLen || (lLen > rLen && lLen < 3)) return false;
            l++;
            r++;
        }
        return l == s.length() && r == t.length();
    }
}
