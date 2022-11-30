package exercise.dailyTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
//正则表达式的使用。
public class 反转字符串中的单词151 {
    public String reverseWords(String s) {
        while(s.startsWith(" ")){
            s = s.substring(1);
        }
        while(s.endsWith(" ")){
            s = s.substring(0, s.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                sb.append(" ");
                while(i + 1 < s.length() && s.charAt(i + 1) == ' '){
                    i++;
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        sb = new StringBuilder();
        List<String> collect = Arrays.stream(sb.toString().split(" ")).collect(Collectors.toList());
        for (int i = collect.size() - 1; i >= 0; i--) {
            sb.append(collect.get(i));
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //使用语言特性 妙啊
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        //将数组转换为List.
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


    public String reverseWords3(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }



    @Test
    public void test(){
        Pattern p = Pattern.compile("1r");
        Matcher m = p.matcher("1rrtete3 43432   222fk  kewrqq we");
        while(m.find()){ //寻找下一个匹配的子文本
            String s = m.group(); //提取
            System.out.println(s + "qq"); //输出
        }
        List<String> collect = Stream.of("1", "2", "3", "4", "5", "6").collect(Collectors.toList());
        System.out.println(String.join("qtz", collect));
    }


}
