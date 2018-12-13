package com.example.demo;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class A {

    @Resource
    B b;
    public void print() {
        System.out.println("I'm AAAAAA"+b);
    }
}
