package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class B {

    @Resource
    A a;
    public void print() {
        System.out.println("I'm BBBBBB"+a);
    }


}
