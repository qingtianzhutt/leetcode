package practise.枚举;

import java.util.ArrayList;
import java.util.List;

public class enumTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        String t = RedisKeyEnum.DMSS_DEVICE.getKey("deviceCode");
        System.out.println(t);
    }

}
