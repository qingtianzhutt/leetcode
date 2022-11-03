package com.example.demo.Controller;

import com.example.demo.service.feignTestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class feignTest {

    @Qualifier("com.example.demo.service.feignTestInterface")
    @Autowired
    private feignTestInterface feignTestInterface;

    @RequestMapping("feignTest")
    public String feignTest(){
        System.out.println("feignTest success");
        return feignTestInterface.feignTest();
    }

}
