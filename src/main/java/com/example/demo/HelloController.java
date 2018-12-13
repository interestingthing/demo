package com.example.demo;

import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

@RestController
public class HelloController {


    @Resource
    Environment environment;


    @GetMapping("/index")
    public String hello() {

        System.out.println("--------------------------------");
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println("spring.profiles.active"+environment.getProperty("spring.profiles.active"));
        System.out.println("server.port"+environment.getProperty("server.port"));
        return "Hello Profile";
    }
}
