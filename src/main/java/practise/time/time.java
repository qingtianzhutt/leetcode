package practise.time;

import java.text.SimpleDateFormat;

/**
 * 十位的时间戳格式是这样的。
 */
public class time {
    public static void main(String[] args) {
        Long time = System.currentTimeMillis();  //获取当前时间
        time = 1642903268200l;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String date = format.format(time);//注意这里返回的是string类型
        System.out.println(date);


    }
}
