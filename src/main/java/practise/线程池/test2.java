package practise.线程池;

import org.junit.Test;
//字符串不是引用传递，是值传递。
public class test2 {
    @Test
    public void test(){
        String s = "1111";
        test1(s);
        System.out.println(s);

    }
    public void test1(String email){
        email = "123123";
    }
}
