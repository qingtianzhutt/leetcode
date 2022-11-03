package practise.多态;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
//        Male male = new Male();
//        male.setPower("22");
//        List<String> s = Stream.of("a","b", "c").collect(Collectors.toList());
//        male.setChildName(s);
//        System.out.println(s);
//        example(male);
//        System.out.println(male.getChildName());
//        Person p1 = new Person("12","qin",true);
//        Person p2 = new Person("13","tao",false);
//        Person p3 = new Person("14","zhi",true);
//        ListPerson l = new ListPerson();
//        List<Person> put = new ArrayList<>();
//        put.add(p1);
//        put.add(p2);
//        put.add(p3);
//        l.setPersons(put);
        Person p1 = new Person();
        p1.setAge("12");
        p1.setName("qin");
        p1.setRight(true);
        System.out.println(p1.toString());
        String s = JSON.toJSONString(p1);
//        JSONObject js = JSONObject.parseObject(JSON.toJSONString(p1));
//        List<JSONObject> res = put.stream().map(e -> {
//            JSONObject js = JSON.parseObject(JSON.toJSONString(e),JSONObject.class);
//            return js;
//        }).collect(Collectors.toList());
        System.out.println(s);
    }
//    public static void example(Person person){
//        if (person instanceof Male){
//            Male male = (Male)person;
//            List<String> s = male.getChildName();
//            List<String> newName = Stream.of("1", "2", "3").collect(Collectors.toList());
//            male.setChildName(newName);
//        }
//    }
}
