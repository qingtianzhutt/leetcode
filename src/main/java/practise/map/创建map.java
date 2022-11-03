package practise.map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
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
    }
}
