package practise.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class testShareRelation {
    public static void main(String[] args) {
        String relation = "{\"account\":\"qintaozhi@chacuo.net\",\"arcAuth\":\"{\\\"modifyDevPassword\\\":{\\\"authType\\\":\\\"modifyDevPassword\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"receiveMessage\\\":{\\\"authType\\\":\\\"receiveMessage\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"hosting\\\":{\\\"authType\\\":\\\"hosting\\\",\\\"enable\\\":\\\"false\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"testArc\\\":{\\\"authType\\\":\\\"testArc\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"viewRoom\\\":{\\\"authType\\\":\\\"viewRoom\\\",\\\"enable\\\":\\\"-1\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"share\\\":{\\\"authType\\\":\\\"share\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"configure\\\":{\\\"authType\\\":\\\"configure\\\",\\\"enable\\\":\\\"false\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"arm\\\":{\\\"authType\\\":\\\"arm\\\",\\\"enable\\\":\\\"-1\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153}}\",\"companyId\":\"207\",\"companyName\":\"Arguson&#39;s Low Voltage Corp.\",\"deviceCatalog\":\"ARC\",\"deviceId\":\"WANGGUANARC30002\",\"deviceName\":\"C30002\",\"fromOpenUserId\":\"6462874\",\"fromUserId\":\"6462874\",\"ownerEmail\":\"dev_parent_4@linshiyouxiang.net\",\"ownerId\":\"6462874\",\"remainHours\":8,\"retainRight\":\"0\",\"startTime\":\"2021-10-19 02:36:20\",\"status\":\"0\",\"toOpenUserId\":\"6932614\",\"type\":\"3\"}";
//        String relation = "{\"account\":\"qintaozhi@chacuo.net\",\"arcAuth\":\"{\\\"modifyDevPassword\\\":{\\\"authType\\\":\\\"modifyDevPassword\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"receiveMessage\\\":{\\\"authType\\\":\\\"receiveMessage\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"hosting\\\":{\\\"authType\\\":\\\"hosting\\\",\\\"enable\\\":\\\"false\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"testArc\\\":{\\\"authType\\\":\\\"testArc\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"viewRoom\\\":{\\\"authType\\\":\\\"viewRoom\\\",\\\"enable\\\":\\\"-1\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"share\\\":{\\\"authType\\\":\\\"share\\\",\\\"enable\\\":\\\"true\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"configure\\\":{\\\"authType\\\":\\\"configure\\\",\\\"enable\\\":\\\"false\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153},\\\"arm\\\":{\\\"authType\\\":\\\"arm\\\",\\\"enable\\\":\\\"-1\\\",\\\"endTime\\\":-1,\\\"startTime\\\":1634610980153}}\",\"companyId\":\"207\",\"companyName\":\"Arguson&#39;s Low Voltage Corp.\",\"deviceCatalog\":\"ARC\",\"deviceId\":\"WANGGUANARC30002\",\"deviceName\":\"C30002\",\"fromOpenUserId\":\"6462874\",\"fromUserId\":\"6462874\",\"ownerEmail\":\"dev_parent_4@linshiyouxiang.net\",\"ownerId\":\"6462874\",\"remainHours\":8,\"retainRight\":\"0\",\"startTime\":\"2021-10-19 02:36:20\",\"status\":\"0\",\"toOpenUserId\":\"6932614\",\"type\":\"3\"}";
//        Object parse1 = JSON.parse(relation);
//        String s = parse1.toString();
//        System.out.println(s);
//        System.out.println(relation);
//        System.out.println(s.length() + ":" + relation.length());
//        ShareRelationship shareRel = JSONObject.parseObject(relation , ShareRelationship.class);
//        System.out.println(shareRel);
//        System.out.println(JSON.toJSONString(shareRel));
//        ShareRelationship shareRel2 = JSON.parseObject(JSON.toJSONString(shareRel), ShareRelationship.class);
//        System.out.println(JSON.toJSONString(shareRel2));
        String s = "dev_parent_4@linshiyouxiang.net";
        String[] spiltEmail = s.split("@");
        spiltEmail[0] += "_b";
        String Emailb = spiltEmail[0] + "@" + spiltEmail[1];
        System.out.println(Emailb);
        User u = new User();
        System.out.println(u.getName());

    }
}
