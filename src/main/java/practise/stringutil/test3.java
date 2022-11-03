package practise.stringutil;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test3 {
    public static void main(String[] args) {
        judgePhoneValid("213123123123123231123","986021475@qq.com");
    }
    public static void judgePhoneValid(String phoneNumber,String email){
        if(phoneNumber != null){
            if(StringUtils.length(phoneNumber) > 64){
                System.out.println(1);
            }
            if(StringUtils.countMatches(phoneNumber,"+") > 1){
                System.out.println(1);
            }
            if(StringUtils.countMatches(phoneNumber,"+") == 1 && !StringUtils.startsWith(phoneNumber,"+")){
                System.out.println(1);
            }
            Pattern ptn1 = Pattern.compile("[0-9]*");
            if(!ptn1.matcher(phoneNumber).matches()){
                System.out.println(1);
            }
        }
        if(StringUtils.length(email) > 64){
            System.out.println(1);
        }
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern ptn2 = Pattern.compile(regEx1);
        if(!ptn2.matcher(email).matches()){
            System.out.println(56);
            System.out.println(1);
        }
    }
}
