package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dog {

    @JsonProperty("xiaoming")
    private String name;


    public String key;
}
