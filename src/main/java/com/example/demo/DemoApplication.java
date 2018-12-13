package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {

    //log4j2

    private static final Logger logger = LogManager.getLogger(DemoApplication.class);
    //lohback
    //final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        final ConfigurableApplicationContext cxt = SpringApplication.run(DemoApplication.class, args);
        System.out.println(Arrays.toString(args));


        //LogbackLoggingSystem
        //PropertiesPropertySourceLoader
        // NewRuleAction
        //AbstractLoggingSystem
        //logbackLoggingSystem
        //  ApplicationListener
        //NewRuleAction=
        for (int i = 1; i <= 10; i++)
            logger.warn("---------------------测试-------------------------------");
            logger.info("----------------------------------------------------");
//            logger.debug("----------------------------------------------------");

    }
}
