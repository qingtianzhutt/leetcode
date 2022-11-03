package practise.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream强转 {
    public static void main(String[] args) throws InterruptedException {
//        User user = new User();
//        System.out.println(user.getName());
//        Object u = user;
//        System.out.println(u);
//        User t = (User)u;
//        System.out.println(t);
//        System.out.println(t.getName() + t.getAge());
//        String s = "{\"account\":\"207\",\"arcAuth\":\"{\\\"modifyDevPassword\\\":{\\\"enable\\\":\\\"false\\\",\\\"startTime\\\":1633937511063,\\\"endTime\\\":1633966311063,\\\"authType\\\":\\\"modifyDevPassword\\\"},\\\"receiveMessage\\\":{\\\"enable\\\":\\\"true\\\",\\\"startTime\\\":-1,\\\"endTime\\\":-1,\\\"authType\\\":\\\"receiveMessage\\\"},\\\"hosting\\\":{\\\"enable\\\":\\\"false\\\",\\\"startTime\\\":1633937511063,\\\"endTime\\\":1633966311063,\\\"authType\\\":\\\"hosting\\\"},\\\"testArc\\\":{\\\"enable\\\":\\\"true\\\",\\\"startTime\\\":-1,\\\"endTime\\\":-1,\\\"authType\\\":\\\"testArc\\\"},\\\"viewRoom\\\":{\\\"enable\\\":\\\"-1\\\",\\\"startTime\\\":-1,\\\"endTime\\\":-1,\\\"authType\\\":\\\"viewRoom\\\"},\\\"share\\\":{\\\"enable\\\":\\\"false\\\",\\\"startTime\\\":1633937511063,\\\"endTime\\\":1633966311063,\\\"authType\\\":\\\"share\\\"},\\\"configure\\\":{\\\"enable\\\":\\\"false\\\",\\\"startTime\\\":1636529511063,\\\"endTime\\\":-1,\\\"authType\\\":\\\"configure\\\"},\\\"arm\\\":{\\\"enable\\\":\\\"-1\\\",\\\"startTime\\\":-1,\\\"endTime\\\":-1,\\\"authType\\\":\\\"arm\\\"}}\",\"companyId\":\"207\",\"deviceCatalog\":\"ARC\",\"deviceId\":\"WANGGUANARC30002\",\"endTime\":\"30\",\"fromUserId\":\"6932614\",\"functions\":\"realtime,videoMonitor,alarmMsg,alarmManage,localVideoRecord,videoRecord,cloudRecordManage,configure,seniorConfigure\",\"ownerId\":\"6932614\",\"startTime\":\"2021-10-11 07:31:51\",\"status\":\"0\",\"type\":\"2\"}";
//        User u = new User();
//        u.setAge(1);
//        u.setName("123");
//        System.out.println(JSON.toJSONString(u));
//        String u1 = "{\"name\":\"123\"}";
//        Object ob = JSONObject.parse(u1);
//        System.out.println(ob.toString());
//        User t = JSONObject.parseObject(u1,User.class);
//        System.out.println(t);

//        RelationRecord r = new RelationRecord();
//        List<String> s  = Stream.of("1", "2", "3").collect(Collectors.toList());
//        System.out.println(s);
//        r.setDeviceCodes(s);
//        r.getDeviceCodes().add("4");
//        System.out.println(JSON.toJSONString(r));
        User u1 = new User();
        u1.setName("qin");
        u1.setAge(1);
        Object o1 = (Object) u1;
        User u2 = new User();
        u2.setName("qin2");
        u2.setAge(2);
        Object o2 = (Object) u2;
        List<User> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        list1.add(u1);
        list1.add(u2);
        list2.add(o1);
        list2.add(o2);
        System.out.println(list1);
        System.out.println(list2.toString());
        List<User> list = list2.stream().map(e -> JSONObject.parseObject(JSON.toJSONString(e), User.class)).collect(Collectors.toList());
        System.out.println(list.getClass());
        list1.addAll(list);
        System.out.println(list1);


    }
}
