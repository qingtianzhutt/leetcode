package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url")
@Data
public class MicroServiceUrl {

    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

}
