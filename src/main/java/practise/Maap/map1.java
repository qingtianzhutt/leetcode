package practise.Maap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class map1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map);
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSONObject.toJSONString(map));
    }
}
