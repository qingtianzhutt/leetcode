package practise.synchroniz;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);
        List<String> list2 = new CopyOnWriteArrayList<>();
        Map<Object,Object> map = new HashMap<>();
        map.put("K1", "231");
        System.out.println(map.get(null));
        Map<Object,Object> map1 = new ConcurrentHashMap<>();
    }
}
