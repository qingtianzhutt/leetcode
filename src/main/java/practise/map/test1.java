package practise.map;

import com.alibaba.fastjson.JSONObject;

public class test1 {
    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<>();
//        map.put("1", null);
//        System.out.println(JSONObject.toJSONString(map));
        String s1 = "{\"arm\":\"0,1,2\",\"modifyDevPassword\":\"false\",\"configure\":\"false\",\"viewRoom\":\"0,1,2\",\"share\":\"false\",\"receiveMessage\":\"true\",\"hosting\":\"false\",\"testArc\":\"false\"}";
//        String s1 = "{\"arm\":\"-1\",\"configure\":false,\"hosting\":false,\"modifyDevPassword\":false,\"receiveMessage\":true,\"share\":false,\"testArc\":false,\"viewRoom\":\"-1\"}";
        JSONObject arcJson = JSONObject.parseObject(s1);
        String power = "Permissions owned: ";
        boolean isRrm = false;
        boolean isViewRoom = false;
        String roomId = "";
        for (Object key : arcJson.keySet()){
            if (key.toString().equals("arm")){
                isRrm = true;
                roomId = arcJson.getString("arm");
            }else if(key.toString().equals("viewRoom")){
                isViewRoom = true;
            }else if (arcJson.get(key.toString()).toString().equals("true")){
                    power += key.toString();
                    power += ",";
            }

        }
        if (isViewRoom){
            power += "viewRoom,";
        }

        if (isRrm){
            power += "arm,";
            power += "roomIds: ";
            String[] single = roomId.split(",");
            String roomIdFinal = "";
            for (String i : single){
                roomIdFinal += String.valueOf(Integer.valueOf(i) + 1);
                roomIdFinal += ",";
            }
            roomIdFinal = roomIdFinal.substring(0, roomIdFinal.length() - 1);
            power += roomIdFinal;
        }
        power = power.replaceAll("0", "all");

//        String[] split = power.split("roomIds: ");
//        if (split[1].equals("0")){
//            power.
//        }
//        if (res.charAt(res.length() - 1) == ','){
//            res = res.substring(0,res.length() - 1);
//        }
        System.out.println(power);


    }
}
