package com.example.demo1.test1;


import aspect.A;
import com.example.demo1.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: chenjingang@gauzi.com  2019/1/2 13:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@ComponentScan(basePackages = {"com.example.demo1"})
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.demo1"})
//@Import(BeanConfig.class)
@ContextConfiguration
@ActiveProfiles("test")
public class BaseTest {

    @Resource
    A a;

    @Value("${port}")
    private Integer port;
//    @Resource(name = "beanConfig")
//    BeanConfig beanConfig;

    @Test
    public void hahaha() {
        System.out.println(a);
        System.out.println(port);
    }
}
