package practise.lambda;

import java.util.function.Consumer;

//消费型接口
public class ConsumerTest {

    public static void main(String[] args) {
        test("hello", x -> System.out.println(x));
    }

    public static <T> void test(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

}

