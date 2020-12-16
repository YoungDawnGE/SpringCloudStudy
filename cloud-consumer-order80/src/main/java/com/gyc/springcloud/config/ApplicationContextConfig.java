package com.gyc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2020/12/8 19:09
 * 配置类
 * 类似 applicationContext.xml <Bean id="" class=""/>
 * 这边使用了注解的方式注入（然后就可以直接用了）
 * @LoadBalanced 开启负载均衡
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced //RestTemplate使用默认的轮询算法需要开启这个注解，这里我们关闭它，手写自己的轮询算的
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
