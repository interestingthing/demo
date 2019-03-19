package com.client;

import com.client.feign.config.FeignConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.Arrays;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, KafkaAutoConfiguration.class})
@ComponentScan(basePackages =
        {
                "com.client"
        },
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {FeignConfig.class}
        )}
)
//@ImportResource(locations = {"classpath:druid-bean.xml"})
@ServletComponentScan
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
//@EnableAsync
@Slf4j
public class DemoApplication {

    //log4j2

    //private static final Logger logger = LogManager.getLogger(com.client.DemoApplication.class);
    //lohback
    //final static Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        System.out.println(Arrays.toString(args));
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("boot by profile:  {} =============================== {} ====== {} ====== {}", profile, profile, profile, profile);
        }
        System.out.println("start over");
        for (int i = 1; i <= 3; i++) {
            log.info("---------------------测试-------------------------------");
        }
        log.info("----------------------------------------------------");
//            logger.debug("----------------------------------------------------");

    }
}
