package com.gyc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by GYC
 * 2021/2/7 20:51
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3356 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3356.class, args);
    }
}
