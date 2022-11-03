package practise.stream流的使用;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test3 {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(num);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        String s = String.valueOf(num.get(1));
        System.out.println(s);
        List<String> eightDeviceDatail = num.parallelStream().map(e->{
            String y = String.valueOf(e);
            return y;
        }).collect(Collectors.toList());
        System.out.println(eightDeviceDatail.get(1));

    }
}
