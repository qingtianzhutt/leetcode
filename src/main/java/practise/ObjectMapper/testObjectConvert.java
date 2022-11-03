package practise.ObjectMapper;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class testObjectConvert {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"dog\":{\"name\":[{\"name1\":true,\"name2\":\"192.168.1.114\"}]}}";
        try {
            tog dog = mapper.readValue(s, tog.class);
            System.out.println(JSON.toJSONString(dog));
        } catch (JsonProcessingException e) {
            System.out.println("error");
        }
    }

}
