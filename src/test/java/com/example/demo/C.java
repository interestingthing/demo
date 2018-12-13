package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.demo"})
@ActiveProfiles("test")
@EnableAutoConfiguration
@Import({Config.class})
public class C {

    @Resource
    A a;

    @Resource
    B b;

    @Test
    public void test1() {
        a.print();
        b.print();



    }

}
