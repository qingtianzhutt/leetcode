package practise.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class test {
    public static void main(String[] args) throws JSONException {
//        String json = "[null,null,null]";
//        JSONArray js = JSON.parseArray(json);
//        System.out.println(js);
//            test6();
        String resultJson = "{\"code\":\"0\",\"data\":{},\"success\":true,\"errMsg\":\"\"}";
        JSONObject js32 = JSONObject.parseObject(resultJson);
        System.out.println(js32.get("data"));
        System.out.println(js32.getString("qwew"));
        System.out.println((Object) js32.get("data") == null);
        System.out.println(js32.get("data").toString());
        System.out.println(js32.get("data").toString().equals("{}"));

    }
    public static void test1() throws JSONException {
        //1. string转jsonarray
//        String json = "[{\"name\":\"张三\",\"code\":\"123\"},{\"name\":\"李四\",\"code\":\"123\"}]";
//        JSONArray jsonArray = JSONArray.parseArray(json);
//        System.out.println("jsonArray: "+jsonArray);
//        System.out.println();
//
//        //2. JSONArray转String
//        String jsonString1 = jsonArray.toString();
//        System.out.println("JSONArray转String: "+jsonString1);
//        //3.String继续转换为json
//        JSONArray jsa = JSONArray.parseArray(jsonString1);
//        System.out.println("jsa: " + jsa);
    }
    public static JSONArray test2(){
        String json = "[{\"devList\":[null,null],\"token\":\"Ut_0000d7e2cdbc63ee49599280b2c3b2b4\"}," +
                "{\"devList\":[\"123\",\"234\"],\"token\":\"Ut_0000d7e2cdbc63ee49599280b2c3b2b4\"}," +
                "{\"devList\":[\"zjxvc\",\"zxciov\"],\"token\":\"Ut_0000d7e2cdbc63ee49599280b2c3b2b4\"}]";
        JSONArray js = JSONArray.parseArray(json);
        return js;
    }

    /**
     * 遍历JSONArray
     * JSONArray含义：array数组,只不过数组是json格式的
     */
    public static void test3() throws JSONException {
        String json = "[{\"name\":\"张三\",\"code\":\"123\"},{\"name\":\"李四\",\"code\":\"123\"}]";
        JSONArray jsonArray = JSONArray.parseArray(json);
        if(jsonArray.size() > 0){
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("遍历jsonArray,获取数组中的name属性值："+jsonObject.get("name"));
            }
        }
        System.out.println();
    }
    /**
     * Array数组转换成JSON字符串
     * json字符串含义：字符串是json格式的
     */
    public static void test4(){
        ArrayList<User> users = new ArrayList<User>();
//        users.add(new User("zhangsan",21));
//        users.add(new User("lisi",18));
//        users.add(new User("wangwu",32));
        JSONArray array = new JSONArray(Collections.singletonList(users));
        System.out.println("Array数组转JSON字符串： "+array.toString());
    }
    /**
     * 将list转化为8个一组的格式
     *
     */
    @Test
    public static void test5(){
        List<Integer> list = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12).collect(toList());
        List<List<Integer>> list1 = com.google.common.collect.Lists.partition(list,8);
        System.out.println(list1.get(1));

        AtomicReference<String> str = new AtomicReference<>();
        List<String> eightDeviceDatail = list1.parallelStream().map(e->{
            Map<String ,Integer> param = new HashMap<>();
            param.put("key",e.get(0));
            System.out.println(param);
            String s = "";
            for (int t : e){
                s += t;
            }
            return s;
        }).collect(Collectors.toList());
        System.out.println(eightDeviceDatail);
    }

    /**
     * org.json.jsonObject与com.alibaba.jsonObject之间转化。
     *经测试好像不可以转换。
     */
    public static void test6(){
        pig a = new pig();
        a.setHead("werw");
        String qintaozhi = Optional.ofNullable(a.getHead()).orElse("qintaozhi");


    }



}
