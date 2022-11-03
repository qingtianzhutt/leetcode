package practise.stringutil;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class test2 {
    public static void main(String[] args) {
//        Pattern ptn1 = Pattern.compile("[0-9]*");
//        String s = "231312jk312";
//        System.out.println(ptn1.matcher(s).matches());
//        System.out.println(isEmail("986021475@q1q.com"));
        //test();
        String[] str = ("wdddddwsssswffffwgggwgb").split("w");
        for (String s:str
             ) {
            System.out.println(s);

        }


    }

    /*
    正则表达式是有顺序的[A-z]{1,}[0-9]{0,}，这个表示字母必须在前面出现，而数字只能在后面出现。{1,}表示最少出现一次，而{0,}
    表示一次也不能出现，相当于不写。
    如果要没有顺序可以写成[A-z0-9]。
    {n,}这个可以妙用为限制长度。
    ^一个是取反的意思，一个是限定开头的意思。
     */
    public static boolean isEmail(String str) {
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern ptn2 = Pattern.compile(regex);
        return ptn2.matcher(str).matches();

    }
    public static void test() {
        String str = "北京市(海淀区)(朝阳区)";
        String paternStr = ".*(?=\\()";
        Pattern pattern = Pattern.compile(paternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}
