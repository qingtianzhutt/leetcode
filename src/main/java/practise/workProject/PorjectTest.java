package practise.workProject;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PorjectTest {
    public static void main(String[] args) {
        awakeModel t1 = new awakeModel(Stream.of(1,2,3).collect(Collectors.toList()), "00:01:00", "00:02:00");
        awakeModel t2 = new awakeModel(Stream.of(1,2,3,4,5,6).collect(Collectors.toList()), "00:05:00", "00:08:30");
        awakeModel t3 = new awakeModel(Stream.of(2,3,4).collect(Collectors.toList()), "00:00:00", "00:20:00");
        awakeModel t4 = new awakeModel(Stream.of(4,5,6).collect(Collectors.toList()), "00:06:00", "00:08:00");
        awakeModel t5 = new awakeModel(Stream.of(0,6).collect(Collectors.toList()), "00:03:00", "00:09:00");
        awakeModel t6 = new awakeModel(Stream.of(2,5).collect(Collectors.toList()), "00:04:00", "00:06:00");
        List<awakeModel> input = new ArrayList<>();
        input.add(t1);
        input.add(t2);
        input.add(t3);
        input.add(t4);
        input.add(t5);
        input.add(t6);
        List<List<String>> res = new ArrayList<>();
        List<String> single1 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single2 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single3 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single4 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single5 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single6 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
        List<String> single7 = Stream.of("0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59","0 00:00:00-23:59:59").collect(Collectors.toList());
            res.add(single1);
            res.add(single2);
            res.add(single3);
            res.add(single4);
            res.add(single5);
            res.add(single6);
            res.add(single7);


//        input.stream().forEach(e -> {
//            e.getData().stream().forEach(k -> res.get(k).add(3,"1 " + e.getBeginTime() + "-" + e.getEndTime()));
//        });
        //i表示第几条计划
//        for (int i = 0; i < input.size(); i++){
//            awakeModel plan = input.get(i);
//            int finalI = i;
//            plan.getData().stream().forEach(k -> res.get(k).set(finalI,"1 " + plan.getBeginTime() + "-" + plan.getEndTime()));
//        }
//        for (int i = 0; i < input.size(); i++){
//            List<Integer> day = input.get(i).getData();
//            String beginTime = input.get(i).getBeginTime();
//            String endTime = input.get(i).getEndTime();
//            day.stream().forEach(e -> {
//                res.get(e).add("1 " + beginTime + "-" + endTime);
//            });
//        }
//        input


        for (int i = 0; i < input.size(); i++){
            awakeModel plan = input.get(i);
            List<Integer> days = plan.getData();
            for (int j = 0; j < days.size(); j++){
                res.get(days.get(j)).set(i, "1 " + plan.getBeginTime() + "-" + plan.getEndTime());
            }
        }
        System.out.println(res);
        //得到res来重新构建返回值
        List<awakeModelOut> output = new ArrayList<>();
        for (int a = 0; a < 6; a++){
            //a对应第几条计划
            awakeModelOut newPlan = new awakeModelOut();
            List<Integer> data = new ArrayList<>();
            Boolean planValid = false;
            //b对应星期几
            for (int b = 0; b < res.size(); b++){
                String time = res.get(b).get(a);
                String[] spiltTime = time.split(" ");
                if ("1".equals(spiltTime[0])){
                    planValid = true;
                    String[] dayAndNight = spiltTime[1].split("-");
                    newPlan.setBeginTime(dayAndNight[0]);
                    newPlan.setEndTime(dayAndNight[1]);
                    data.add(b);
                }
            }
            if (planValid){
                newPlan.setData(data);
                output.add(newPlan);
            }
        }
        System.out.println(output);


    }
}
