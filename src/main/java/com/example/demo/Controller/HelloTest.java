package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.SwaggerResultMessage;
import com.example.demo.vo.AppUpgradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@RestController
public class HelloTest {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("testq")
    public String feignTest(){
        System.out.println("hello world");
        return "hello world";
    }

    @RequestMapping("testq1")
    public SwaggerResultMessage<AppUpgradeDTO> feignTest1(){
        System.out.println("hello world");
        AppUpgradeDTO appUpgradeDTO = new AppUpgradeDTO(1, "11", 2l);
        return new SwaggerResultMessage<>(appUpgradeDTO);
    }

    @RequestMapping("testq2")
    public JSONObject feignTest2(){
        String url = "http://localhost:19999/testq1";
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);
        JSONObject js = new JSONObject();
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity(js, httpHeaders);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, JSONObject.class);
        if (responseEntity.getStatusCodeValue() == 200){
            System.out.println(responseEntity.getBody().getJSONObject("data"));
        }
        return Objects.requireNonNull(responseEntity.getBody()).getJSONObject("data");
    }
}
