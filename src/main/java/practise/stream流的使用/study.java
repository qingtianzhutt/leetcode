package practise.stream流的使用;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class study {
    public static void main(String[] args) {
        List<String> names = new ArrayList() {{
            add("Tom");
            add("Sally");
            add("John");
            add("qin");
            add("qin");
        }};
        test1(names);
        System.out.println(names);
        //distinct(names);
        //flatMap(names);
//        Map(names);
    }
    public static void test1(List<String> list){
        List<String> res = list.parallelStream().filter(e -> e.contains("n")).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(res);
        list = null;
    }
    public static void distinct(List<String> list){
        List<String> res = list.stream().distinct().collect(Collectors.toList());
        System.out.println(res);
    }
    public static Stream<Character> changeStringToCharacter(String s){
        List<Character> example = new ArrayList<>();
        for (Character character : s.toCharArray()){
            example.add(character);
        }
        return example.stream();
    }

    //这个就是流处理的扁平化处理，list的元素都处理了之后统一处理。
    public static void flatMap(List<String> list){
        List<Character> res = list.stream().flatMap(e -> changeStringToCharacter(e)).collect(Collectors.toList());
        System.out.println(res);
    }


    public static void Map(List<String> list){
        List<Stream<Character>> res = list.stream().map(e -> changeStringToCharacter(e)).collect(Collectors.toList());
        System.out.println(res.toString());
    }
}
