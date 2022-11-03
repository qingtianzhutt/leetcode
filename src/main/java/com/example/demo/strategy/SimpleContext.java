package com.example.demo.strategy;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@Slf4j
public class SimpleContext {
    //什么时候加载的？？？？？
    @Autowired
    private final Map<String, Strategy> strategyMap = Maps.newConcurrentMap();

    public SimpleContext(Map<String, Strategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    public String getResource(String poolId){
        String p=null;
        try {
            p = strategyMap.get(poolId).getVpcList(poolId);
        }catch (Exception e){
            p=poolId;
            log.info("返回原始数据",poolId);
        }finally {
            return  p;
        }
    }
}
