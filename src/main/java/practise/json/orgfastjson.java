package practise.json;

import com.alibaba.fastjson.JSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class orgfastjson {
    public static void main(String[] args) throws JSONException {

        JSONArray a = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ss","ss");
        jsonObject.put("wwww","wwww");
        a.put(0,jsonObject);
//        a.put(0,"1");
//        a.put(1,"2");
        System.out.println(a);
        String s = JSON.toJSONString(a);
        System.out.println(a);
        com.alibaba.fastjson.JSONArray js = com.alibaba.fastjson.JSONObject.parseObject(s, com.alibaba.fastjson.JSONArray.class);
        System.out.println(js);

    }

}
