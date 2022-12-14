package com.example.demo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HytrixService {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixBack")
    public String hello(){
        String forObject = restTemplate.getForObject("http://CONSUMER2/hystrixTest", String.class);
        System.out.println(forObject);
        return forObject;
    }
    public String hystrixBack(){
        return "error";
    }
}
