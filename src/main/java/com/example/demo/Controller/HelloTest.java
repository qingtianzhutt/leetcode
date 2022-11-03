package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {
    @RequestMapping("testq")
    public String feignTest(){
        System.out.println("hello world");
        return "hello world";
    }
}
