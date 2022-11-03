package com.example.demo.strategy;


import org.springframework.stereotype.Component;

@Component("B")
public class ResourceB implements Strategy{
    @Override
    public String getVpcList(String id) {
        /*执行A事件*/
        System.out.println("A,getVpcList ==========="+id);
        return "A";
    }

}
