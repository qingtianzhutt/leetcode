package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 翻转数字 {
    public static void main(String[] args) {
        System.out.println(reverse(123456789));
    }
    public static int reverse(int x) {
        int sign = 0;
        if(x < 0){
            sign = 1;
            x = -x;
        }
        List<Integer> list = new ArrayList<>();
        while(x > 0){
            list.add(x%10);
            x/=10;
        }
        //int len = list.size();
        String res = "";
        //Collections.reverse(list);
        for(Integer i : list){
            res += i;
        }
        if(res.compareTo("2147483648") < 0 ||(res.equals("2147483648")&&sign == 0))return 0;
        return  sign == -1 ? sign*Integer.parseInt(res) :Integer.parseInt(res);
    }
}
