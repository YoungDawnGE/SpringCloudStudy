package com.gyc.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2020/12/8 19:09
 * 配置类
 * 类似 applicationContext.xml <Bean id="" class=""/>
 * 这边使用了注解的方式注入（然后就可以直接用了）
 */
@Configuration
public class AppliactionContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
