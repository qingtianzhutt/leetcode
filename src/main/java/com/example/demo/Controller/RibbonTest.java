package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class RibbonTest {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbonTest")
    public void test(){
        log.info("ribbonTest success...");
//        String s = restTemplate.getForEntity("http://CONSUMER2/ribbonTest2", String.class).getBody();
        ServiceInstance si = loadBalancerClient.choose("CONSUMER2");

        System.out.println("Host: " + si.getHost());
        System.out.println("port: " + si.getPort());
        System.out.println("InstanceId: " + si.getInstanceId());
        System.out.println("Metadata: " + si.getMetadata());
        System.out.println("Scheme: " + si.getScheme());
        System.out.println("ServiceId: " + si.getServiceId());
        System.out.println("Uri: " + si.getUri());

        String forObject = restTemplate.getForObject("http://CONSUMER2/ribbonTest2", String.class);
        System.out.println(forObject);
    }

}
