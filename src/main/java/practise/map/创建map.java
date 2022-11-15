package practise.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 创建map {
    public static void main(String[] args) {
        ImmutableMap<String, Integer> map1 = ImmutableMap.of(
                "a", 1,
                "v", 2,
                "c", 3,
                "d", 4,
                "b", 4);
        System.out.println(map1);
        ImmutableMap<Object, Object> build1 = ImmutableMap.builder().put("a", 1).put("b", 4).put("c", 4).put("d", 4).put("e", 4).put("g", 4).build();
        System.out.println(build1);
        //对map进行迭代。
        for (Object i : build1.values()){
            System.out.println(i);
        }
        Map<String, String> hashmap = new HashMap<>();
        Map<Object, Object> hashMap2 = new HashMap<>();
        hashMap2.put("1", "1");
        hashMap2.put("2", "2");
        hashmap = JSONObject.parseObject(JSON.toJSONString(hashMap2), hashmap.getClass());
        System.out.println(hashmap);

        //遍历map
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}
