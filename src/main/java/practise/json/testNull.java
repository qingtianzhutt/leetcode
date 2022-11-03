package practise.json;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class testNull {

    private final static Set set = new HashSet(){{
        add("VideoMotion");
        add("SmartMotionHuman");
        add("CrossRegionDetection");
        add("AudioMutation");
    }};

    public static void main(String[] args) {


        String content = "{\"data\":{\"msg\":\"51065948::8865f775-8dca-478e-9e35-190213c689ac::3::arossRegionDetection::2022-08-05 10:19:20\"},\"groups\":[{\"senderId\":\"172899845816\",\"clientType\":\"Android\",\"appType\":\"dmss\",\"clientInfos\":[{\"phoneId\":\"d4yw8eld_KM:APA91bFuh2pKdg1Mq0p0yLJskV1EsrbMGHTYZ8jsxXh56JEl6KW0Y7-Ox7XY7YXEUl-OkOp8-_fDQHxxl2Jj3o5j4Y7_3YvtjhF7jUkodcd2g5HeTs3OAHPt4VXQPxQZkY6NRkT7ZalE\"}],\"appID\":108,\"type\":0}],\"isRepush\":false}";
        JSONObject contentJs = JSONObject.parseObject(content);
        System.out.println(contentJs);
//        if (!contentJs.containsKey("data"))return;
//        if (!contentJs.getJSONObject("data").containsKey("msg"))return;
//        String msg = contentJs.getJSONObject("data").getString("msg");
//        System.out.println(msg);
//        String[] msgSplit = msg.split("::");
//        if (msgSplit.length < 4)return;
//        String messageType = msgSplit[3];
//        if (!set.contains(messageType))return;
//        System.out.println(true);

        String s = Optional.ofNullable(contentJs)
                .filter(a -> a.containsKey("data") && a.getJSONObject("data") != null)
                .map(a -> a.getJSONObject("data"))
                .filter(a -> a.containsKey("msg") && "51065948::8865f775-8dca-478e-9e35-190213c689ac::3::arossRegionDetection::2022-08-05 10:19:20".equals(a.getString("msg")))
                .map(b -> b.getString("msg"))
                .orElse("cuowu");
        System.out.println("safafasfaf         " + s);
//        String s = "videoMotion、smdHuman、smdVehicle、videoBlind、NetMonitorAbort、crossLineDetection、crossRegionDetection、crossRegionDetection_Cross、crossRegionDetection_Disappear、SceneChange、StorageNotExist、StorageLowSpace、StorageFailure、LeftDetection、TakenAwayDetection、VideoUnFocus、aiFaceDetect、aiAFaceCompa、aiFriendFaceCompa、aiSFaceCompa、aiStrangerFaceCompa、TrafficJunction、MoveDetection、queueNumDetection、hoveringAlarm、AnatomyTempDetect、BetweenRulesTemperDiffAlarm、AudioAnomaly、AudioMutation、tumbleDetection、fightDetection、distanceDetection、manNumDetection、queueNumDetection、heatImagingTemper、fireAlarm、HotSpotWarning、ColdSpotWarning、smokingDetect、phoneCallDetect、SmokeDetection、underVoltage、OverVoltage、wireLessDevLowPower、SCADADevAlarm、SCADADevAlarm_LowBattery、SCADADevAlarm_BatteryRestored、AlarmIPC、CoaxialAlarmLocal、CoaxialHighTemperatureAlarm、CoaxialLowTemperatureAlarm、CoaxialHighHumidityAlarm、CoaxialLowHumidityAlarm、AlarmLocal、CrowdDetection_Limit、CrowdDetection_All、CrowdDetection_Density、CrowdDetection、AlarmNet、WanderDetection、StorageNotExist";
//        String[] split = s.split("、");
//        Arrays.stream(split).forEach(e -> e.toLowerCase());
//        System.out.println(split);
//        List<String> collect = Arrays.stream(split).map(e -> e.toLowerCase()).collect(Collectors.toList());
//        System.out.println(collect.size());
//        List<String> collect1 = collect.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect1.size());
//        System.out.println(collect);
//        System.out.println(collect1);
//        System.out.println(JSON.toJSONString(collect));
    }
}
