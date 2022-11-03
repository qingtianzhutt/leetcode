package practise.workProject;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test111 {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sin = Stream.of(1,2).collect(Collectors.toList());
        res.add(sin);
        List<Integer> sin11 = Stream.of(2,3).collect(Collectors.toList());
        res.get(0).add(3);
        res.add(sin11);
        System.out.println(res);
        res.get(1).set(0, 99);
        System.out.println(res);
//        res.add(new ArrayList<>());
//        res.get(0).add(1);
//        System.out.println(res);





    }
}
