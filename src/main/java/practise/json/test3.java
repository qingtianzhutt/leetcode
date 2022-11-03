package practise.json;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class test3 {
    public static void main(String[] args) {
        JSONObject device1 = new JSONObject();
        JSONObject device2 = new JSONObject();
        JSONObject device3 = new JSONObject();
        device1.put("name","小明");
        device2.put("name","小申达股份");device3.put("name","小电风扇");
        device1.put("age","29");device2.put("age","25");device3.put("age","21");
        device1.put("sex","男");device2.put("sex","女");device3.put("sex","男");
        JSONObject device = new JSONObject();
        JSONArray jsa = new JSONArray();

        jsa.add(device1);
        jsa.add(device2);
        jsa.add(device3);
//        System.out.println(jsa);
//        System.out.println(jsa.toString());
//        System.out.println(jsa.toJSONString());
        device.put("jsa",jsa);
//        System.out.println(device);
//        System.out.println(device.toString());
//        System.out.println(device.toJSONString());
        JSONArray jsa2 = new JSONArray();
        for (int i = 0; i < jsa.size(); i++){
            JSONObject obj = (JSONObject) jsa.get(i);
            jsa2.add(obj);
        }
        List<JSONObject> collect = (List<JSONObject>) jsa2.stream().map(lon -> {
            return lon;
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            System.out.println(i);
        }

//        System.out.println(jsa2);
//        System.out.println(jsa2.toString());
//        System.out.println(jsa2.toJSONString());


//        String js1 = "[{\"sex\":\"男\",\"name\":\"小明\",\"age\":\"29\"},{\"sex\":\"女\",\"name\":\"小申达股份\",\"age\":\"25\"},{\"sex\":\"男\",\"name\":\"小电风扇\",\"age\":\"21\"}]";
//        JSONArray res = JSONArray.parseArray(js1);
//        String jssss = "{\"commonStr\":{\"deviceList\":[{\"deviceId\":\"WGDAHUATECH12333\",\"channelList\":\"\"},{\"deviceId\":\"4G06856PAZAED9A\",\"channelList\":\"\"},{\"deviceId\":\"6C03292YAG6CA88\",\"channelList\":\"0\"}]},\"vtoStr\":[]}";
//        JSONObject ob = JSONObject.parseObject(jssss);
//        JSONArray commonDeviceList = ob.getJSONObject("commonStr").getJSONArray("deviceList");
//        System.out.println(commonDeviceList);
        User u = new User();
        if (u == null) {
            System.out.println(1);
        }

    }

}