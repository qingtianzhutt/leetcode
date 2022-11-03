package practise.input;

import java.util.Arrays;

public class judgeInput {
    public static void main(String[] args) {
        System.out.println(1);
        test("1", "2", "3", "4");
        test("1", "2", "3", "4", "5");
    }
    public static void test(String... params){
        System.out.println(params.length);
        for (String param : params) {

        }


    }
}
