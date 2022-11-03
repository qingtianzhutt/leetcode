package practise.string;

import com.google.common.collect.ImmutableMap;

public class sunstring {
    public static void main(String[] args) {
        String test = "1626771289436";
        test = test.substring(0,11);
        System.out.println(test);


        ImmutableMap<String, String> hashValByUserIdKey = ImmutableMap.of("key", "1", "qin", "");
        System.out.println(hashValByUserIdKey.get("key").length());
        System.out.println(hashValByUserIdKey.get("qin").length());
    }
}
