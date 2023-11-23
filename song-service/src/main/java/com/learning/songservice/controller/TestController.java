package com.learning.songservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class TestController {

    @Value("${application.param.a}")
    private int a;
    @Value("${application.param.b}")
    private int b;
    @GetMapping("/test")
    public Map<String,Integer> getParams(){
        return Map.of("a",a,"b",b);
    }

}
