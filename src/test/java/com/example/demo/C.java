package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.xml.transform.dom.DOMResult;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.demo"})
@ActiveProfiles("test")
//@EnableAutoConfiguration
@Import({Config.class})
public class C {

    @Resource
    A a;

    @Resource
    B b;

    @Test
    public void test1() {

        //applicationContext.getBean()

        b.print();
       // Mockito.when(a.print()).thenReturn(0);
        Mockito.doReturn(-1).when(a).print();
        Integer print = a.print();
        System.out.println(print);

    }

}
