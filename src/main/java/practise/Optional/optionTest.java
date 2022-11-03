package practise.Optional;

import java.util.Optional;

public class optionTest {
    public static void main(String[] args) {
        PersonTest p = new PersonTest("1", "2", "34");
        String s = Optional.ofNullable(p.getHeight()).orElse("1231");
        //orElseGet是函数式编程的使用
        String t = Optional.ofNullable(p.getHeight()).orElseGet(() -> "123");
        //如果不为空做对应的处理
        Optional.ofNullable(p.getHeight()).ifPresent(System.out::println);
        System.out.println(t);
        Object o = Optional.ofNullable(null).orElse("1");
        lll(3);
    }
    public static void st(Object e){
        System.out.println("s");
    }
    public static void lll(final int i){
        System.out.println(i);
    }
}
