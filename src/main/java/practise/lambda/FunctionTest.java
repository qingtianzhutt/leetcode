package practise.lambda;

import java.util.function.Function;
//函数型接口
public class FunctionTest {

    public static void main(String[] args) {
        String test = test("hello", x -> x.toUpperCase());
        System.out.println(test);
    }

    public static String test(String str, Function<String, String> function) {
        return function.apply(str);
    }
}

