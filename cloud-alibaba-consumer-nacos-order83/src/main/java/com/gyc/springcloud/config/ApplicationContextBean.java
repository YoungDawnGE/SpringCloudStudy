package com.gyc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2021/2/10 18:36
 */
@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced//这个注解要加 不然报错
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
