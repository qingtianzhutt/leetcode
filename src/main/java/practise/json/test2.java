package practise.json;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONException;

public class test2 {
    public static void main(String[] args) throws JSONException {
//        JSONObject js1 = new JSONObject();
//        js1.put("qin","tao");
//        String s = js1.toString();
//        System.out.println(s);
//        JSONObject js = new JSONObject(s);
//        System.out.println(js);
//        js.put("caps",123);
//        System.out.println(js);
//        System.out.println(js.get("caps"));
        String i = "{\"code\":10000,\"desc\":\"success\",\"data\":{\"logs\":[{\"createTime\":1638176014000,\"id\":1,\"operateType\":\"loginFailed\",\"operateUserName\":\"qintaozhi@chacuo.net\"}]}}";
        JSONObject jsonObject = JSON.parseObject(i);
        if (jsonObject != null && jsonObject.containsKey("code") && jsonObject.getString("code").equals("10000")) {
            //do nothing
        } else {
            System.out.println(100);
        }
    }
}
