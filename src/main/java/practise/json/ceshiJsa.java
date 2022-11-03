package practise.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.concurrent.atomic.AtomicReference;

public class ceshiJsa {
    public static void main(String[] args) {
        String qin = "[\"11\",\"22\"]";
        JSONArray js = JSON.parseArray(qin);
        System.out.println(js);
        String string = js.getString(0);
        String input = "22";
        System.out.println(string);

    }
}
