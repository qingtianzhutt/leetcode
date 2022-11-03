package practise.stringutil;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class test1 {
    public static void main(String[] args) {
        String s = "12311112{123123{*2313131{1";
        int res =StringUtils.countMatches(s,"{");
        System.out.println(res);
        if(s.startsWith("123")){
            System.out.println("cuowu");
            System.out.println("cuowu".toUpperCase());
        }
        if(StringUtils.containsAny(s,"*","%","$")){
            System.out.println("success");
        }
        int k = StringUtils.length(s);
        System.out.println(k);

    }

}


