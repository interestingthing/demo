package com.example.demo;


import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class Config {

    @Bean
    public A A() {
        return Mockito.mock(A.class);
    }

    @Bean
    public B B() {
        return Mockito.spy(B.class);
    }
}
