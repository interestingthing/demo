package com.example.demo1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

//@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.demo1"})
//@ComponentScan(excludeFilters = {
//                @ComponentScan.Filter(
//         clean               type = FilterType.CUSTOM,
//                        classes = TypeExcludeFilter.class)}
//                )
//@Import(BeanConfig.class)
public class TestApplication {

    //log4j2

    private static final Logger logger = LogManager.getLogger(TestApplication.class);
    //lohback
    //final static Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {

        final ConfigurableApplicationContext cxt = SpringApplication.run(TestApplication.class, args);
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
