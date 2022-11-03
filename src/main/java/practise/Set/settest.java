package practise.Set;

import io.swagger.models.auth.In;

import java.util.HashSet;

public class settest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("3");
        for (String i : set){
            System.out.println(i);
        }
        String name = "qintaozhi";
        String t = name.concat("123");
        System.out.println(t);

    }
}
