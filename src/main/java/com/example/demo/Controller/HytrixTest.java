package com.example.demo.Controller;

import com.example.demo.service.HytrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HytrixTest {

    @Autowired
    private HytrixService hytrixService;

    @RequestMapping("/hytrixTest")
    public String hytrixTest(){
        return hytrixService.hello();
    }

}
