package practise.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class datetest1 {
    public static void main(String[] args) throws ParseException {
        //字符串转换为日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse("2020-12-05 16:31:39");
//        System.out.println(date);
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("y===M===d");
//        String str = dateFormat.format(date);
//        System.out.println(str);
//        Date date=new Date();
//        Long startTime = date.getTime();
//        System.out.println(startTime);
//        Calendar cal=Calendar.getInstance();
//        cal.setTime(date);
//        System.out.println(cal.getTime());
//        cal.add(Calendar.HOUR,8);
//        System.out.println(cal.getTime());
//        cal.add(Calendar.HOUR,-8);
//        System.out.println(cal.getTime());
//        System.out.println(cal);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2021-10-28 06:19:11");
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(new Date().getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("y-MM-dd");
        String str = dateFormat.format(date);
        System.out.println(str);



        Map<String, String> openUserMap = new HashMap<>();
        if (openUserMap != null && !openUserMap.isEmpty()){
            System.out.println(1);
        }


    }
}
