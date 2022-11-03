package practise.多态;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class test2 {
    public static void main(String[] args) throws IOException {
        String s = "{\"UserInfos\":[{\"AuthorityList\":[\"Arm\",\"Disarm\"],\"Card\":[],\"DuressPassword\":\"123456\",\"Group\":\"Admin\",\"Id\":\"43328946740\",\"Name\":\"981827802\",\"Password\":\"123456\",\"Reserved\":false,\"Status\":\"Activated\",\"UserType\":\"Keypad\"}]}";
        JSONObject js = JSONObject.parseObject(s);
        JSONArray jsa = js .getJSONArray("UserInfos");
        System.out.println(js);
        List<UserInfo> a = (List<UserInfo>)js.get("UserInfos");
        System.out.println(a.getClass());
        System.out.println(a);
        ObjectMapper objectMapper  = new ObjectMapper();


        List<UserInfo> userInfo = objectMapper.readValue(JSON.toJSONString(jsa), new TypeReference<List<UserInfo>>() {
        });

        System.out.println(userInfo);
    }
}
