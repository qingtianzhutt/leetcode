package practise.stream流的使用;

import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        List<String> string = new ArrayList<String>(){
            {
                add("2");
                add("3");
                add("4");
                add("5");
            }
        };
        string.parallelStream().forEach(a -> print(a));
        print2("qintaozhi","hanyaqun","xiaoming","xihuan");
        try{
            int i = 1 / 0;
        }catch (Exception e){
            throw e;
        }
        System.out.println(222);
    }



    public static void print(String sysIn){
        System.out.println(sysIn);
    }
    public static void print2(String... keys){
        System.out.println(keys.getClass());
        for(String s : keys){
            System.out.println(s);
        }
    }
}
