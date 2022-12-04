package exercise.dailyTest;

import org.junit.Test;

public class 简单题无效题目汇总 {

    /*
    1796. 字符串中第二大的数字
    给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
    混合字符串 由小写英文字母和数字组成。
     */
    public int secondHighest(String s) {
        int maxVal = Integer.MIN_VALUE, secondMaxVal = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                int num = Integer.valueOf(s.charAt(i) - '0');
                if (num > maxVal){
                    if (maxVal == Integer.MIN_VALUE){
                        maxVal = num;
                    }else {
                        secondMaxVal = maxVal;
                        maxVal = num;
                    }
                }else if (num < maxVal && num > secondMaxVal){
                    secondMaxVal = num;
                }
            }
        }
        return secondMaxVal;
    }
    @Test
    public void test(){
        String s = "dfa12321afd";
        secondHighest(s);
    }
}
