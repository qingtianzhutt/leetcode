package practise.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class 合并两个JSONArray {
    public static void main(String[] args) {
//        String js1 = "[{\"sex\":\"男\",\"name\":\"小明\",\"age\":\"29\"},{\"sex\":\"女\",\"name\":\"小申达股份\",\"age\":\"25\"}]";
//        JSONArray res1 = JSONArray.parseArray(js1);
//        System.out.println(res1);
//        String js2 ="[{\"sex\":\"男\",\"name\":\"小电风扇\",\"age\":\"21\"}]";
//        JSONArray res2 = JSONArray.parseArray(js2);
//        System.out.println(js2);
//        System.out.println(res1);
//        JSONArray.toJSONString(res2);

        String js1 = "[{\"sex\":\"男\",\"name\":\"小明\",\"age\":\"29\"},{\"sex\":\"女\",\"name\":\"小申达股份\",\"age\":\"25\"}]";
        JSONArray res1 = JSONArray.parseArray(js1);
        System.out.println(res1);
        for (Object info : res1){
            JSONObject t = (JSONObject)info;
            System.out.println(t);
            t.put("qin", "qin");
        }
        System.out.println(res1);


    }
}
