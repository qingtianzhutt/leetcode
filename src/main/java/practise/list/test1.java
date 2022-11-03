package practise.list;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        list.add(11);
//        list.add(12);
//        list.add(13);
////        List<List<Integer>> partition = Lists.partition(list, 2);
////        //subList就是前闭后开。
////        List list2 = partition.subList(0,1);
////        System.out.println(partition);
////        System.out.println(list2);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(100);
//        List<Integer> all = new ArrayList<>();
//        all.addAll(list);
//        System.out.println(all);
//        all.addAll(list2);
//        System.out.println(all.getClass());
//
//        JSONObject js = new JSONObject();
//        js.put("1","1");
//        js.put("2",null);
//        System.out.println(js);
//        List<Object> objects = Collections.emptyList();
//        System.out.println(objects);
//        System.out.println(objects == null );
//        System.out.println(objects.size() == 0);
//        List<Integer> list = Stream.of(1,2,3).collect(Collectors.toList());
//        list.add(0,50);
//        list.set(0,100);
//        System.out.println(list);
//        List<Integer> test = list.stream().filter(e -> e.equals(100)).collect(Collectors.toList());
//        System.out.println(test);
//        String s = "123";
//        String t = "123";
//        System.out.println(!s.equals(t));
//        List<Integer> areas = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32).collect(Collectors.toList());
//        for (int i = 0; i < areas.size(); i++) {
//            System.out.println(areas.get(i));
//        }



        List l = new ArrayList();
        for (int i = 0; i < 10; i++){
            JSONObject t = new JSONObject();
            t.put("1", "1");
            l.add(t);
        }
        System.out.println(l);

    }
}
