package com.example.demo.Controller;

import com.example.demo.bean.Dog;
import com.example.demo.strategy.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private SimpleContext simpleContext;

    @RequestMapping("/choose")
    public String choose(String poolId){
        return simpleContext.getResource(poolId);
    }

    @RequestMapping(value = "/testJson",method = RequestMethod.POST)
    public Dog testJson(@RequestBody Dog dog1){
        System.out.println(dog1);
        Dog dog = new Dog();
        dog.setName("qintaozhi");
        return dog;
    }
}
