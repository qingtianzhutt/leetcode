package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component("秦涛智A")
public class ResourceA implements Strategy{
    @Override
    public String getVpcList(String id) {
        /*执行A事件*/
        System.out.println("A,getVpcList ==========="+id);
        return "A";
    }

}
