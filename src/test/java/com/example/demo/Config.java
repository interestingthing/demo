package com.example.demo;


import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration

public class Config {
    Logger logger = LoggerFactory.getLogger(Config.class);

    @Bean
    public A a() {
        logger.info("Mock AAAAAA");
        return Mockito.mock(A.class);
    }

    @Bean
    public B b() {
        logger.info("Mock BBBBBBB");
        return Mockito.spy(B.class);
    }
}
