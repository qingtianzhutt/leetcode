package practise.json;

import org.json.JSONException;

import java.util.HashMap;

public class test4 {
    public static void main(String[] args) throws JSONException {
        HashMap<String, String> param = new HashMap<String, String>(){{
            put("deviceId", "123123142");
            put("value", "cardId");
        }};
        pig p = new pig();
        p.setHead("1232");
        p.getMouth().setMouthSize("11");
    }
}
