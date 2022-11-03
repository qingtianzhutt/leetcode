package com.example.demo.Controller;

import com.example.demo.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTest {

    @Autowired
    private RedisDao redisDao;


    @RequestMapping("/redisTest")
    public String redisTest(){
        System.out.println("user success");
        redisDao.setKey("qintaozhi", "dalao");
        return "success";
    }
}
