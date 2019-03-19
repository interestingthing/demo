package com.client.feign.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import feign.httpclient.ApacheHttpClient;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author madenghui
 * spring-cloud-openfeign
 */
@Configuration
@Slf4j
public class FeignConfig {

    /**
     * 有关hystrix相关的配置见app.yml
     * @return
     */
    @Bean
    public Feign.Builder hystrixBuilder(){
        return HystrixFeign.builder();
    }

    /**
     * 配置使用peign原生协议和注解
     * @return
     */
//    @Bean
//    public Contract feignContract() {
//        return new Contract.Default();
//    }

//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }
//
//    @Resource
//    private ObjectFactory<HttpMessageConverters> messageConverters;
//
//    @Bean
//    public Encoder feignFormEncoder() {
//        return new SpringFormEncoder(new SpringEncoder(messageConverters));
//    }
//
//    @Bean
//    public Encoder feignEncoder(){
//        ObjectMapper objectMapper = new ObjectMapper();
//       // objectMapper.configure(SerializationFeature.)
//        return new SpringFormEncoder();
//    }



//    @Autowired
//    private ObjectFactory<HttpMessageConverters> messageConverters;
//    // new一个form编码器，实现支持form表单提交
//    @Bean
//    public Encoder feignFormEncoder() {
//        return new SpringFormEncoder(new SpringEncoder(messageConverters));
//    }

    @Bean
    public Encoder feignEncoder(){
        //ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.configure(SerializationFeature.)
        FeignEncoder feignEncoder = new FeignEncoder(new JacksonEncoder());
        return feignEncoder;
    }


    @Bean
    public Decoder feignDecoder(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return new JacksonDecoder(objectMapper);
    }

    @Bean
    public Request.Options feignOptions(){
        return new Request.Options(5000, 15000);
    }

    @Bean
    public Retryer feignRetryer(){
//        return new Retryer.Default(5000, 5000, 0);
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public FeignLogger feignLogger(){
        return new FeignLogger();
    }
    @Bean
    public ErrorDecoder errorDecoder(){
        return new ErrorDecoder() {
            @Override
            public Exception decode(String s, Response response) {
                log.info("==================================");
                log.info("feign error {}", s);
                return null;
            }
        };
    }
}
