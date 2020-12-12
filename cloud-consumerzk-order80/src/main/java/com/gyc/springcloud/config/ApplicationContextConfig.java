package com.gyc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2020/12/12 10:08
 * 配置类
 * 类似 applicationContext.xml <Bean id="" class=""/>
 * 这边使用了注解的方式注入（然后就可以直接用了）
 * @LoadBalanced 开启负载均衡
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
