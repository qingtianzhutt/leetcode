package practise.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

//供给型接口
public class SupplerTest {

    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x = 0; x < num; x++) {
            list.add(supplier.get());
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = supply(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }

}

