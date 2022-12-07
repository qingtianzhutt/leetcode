package exercise.dailyTest;

import org.junit.Test;

import java.util.Arrays;

/*
给你一个字符串 word ，该字符串由数字和小写英文字母组成。
请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
返回对 word 完成替换后形成的 不同 整数的数目。
只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 */
//要注意边界条件啊。还是用最朴素的方法去做吧。
public class 字符串中不同整数的数目1805 {
    public int numDifferentIntegers(String word) {
        if (word == null || word.length() == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            if (Character.isDigit(word.charAt(i))){
                sb.append(word.charAt(i));
            }else{
                sb.append(" ");
            }
        }
        String[] split = sb.toString().trim().split("\\ +");
        if (Arrays.stream(split).anyMatch(e -> e.equals(""))){
            return 0;
        }
        long count = Arrays.stream(split).map(Integer::valueOf).distinct().count();
        return (int) count;
    }

    @Test
    public void test(){
        String s = "u";
        System.out.println(numDifferentIntegers(s));
    }
}
