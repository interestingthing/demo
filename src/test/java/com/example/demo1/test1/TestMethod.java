package com.example.demo1.test1;


import aspect.A;
import org.junit.Test;

import javax.annotation.Resource;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@ContextConfiguration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@ComponentScan(basePackages = {"com.example.demo1"})
//@Import({BeanConfig.class})
//@ActiveProfiles("dev")
public class TestMethod extends BaseTest {

    @Resource
    A a;
//    @Resource(name = "beanConfig")
//    BeanConfig beanConfig;

    @Test
    public void hahaha() {
        System.out.println(a);
    }

}
