package com.example.demo.service;

import com.example.demo.bean.User;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceFallBack implements feignTestInterface{


    @Override
    public String feignTest() {
        System.out.println("调用接口失败，对服务进行降级处理");
        return "服务繁忙，请稍后重试";
    }

    @Override
    public String hello(String name) {
        return null;
    }

    @Override
    public User hello(String name, Integer age) {
        return null;
    }

    @Override
    public String hello(User user) {
        return null;
    }
}
