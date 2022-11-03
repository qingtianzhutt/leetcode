package practise.stream流的使用;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
            add("d");
            add("e");
        }};
        List<String> res = new ArrayList<>();
        List<String> collect = list.stream().map(a -> a + "12 23").collect(Collectors.toList());
        list.parallelStream().forEach(a -> res.add(a));
        System.out.println(res);
        System.out.println(collect);



        List<Integer> cnt = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        System.out.println(cnt);
        List<Integer> collect1 = cnt.stream().map(e -> e = e + 1).collect(Collectors.toList());
        System.out.println(cnt);
        System.out.println(collect1);
    }
    public static void print1(String s){
        System.out.println(s);
    }
}
