package com.gyc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by GYC
 * 2020/12/15 0:30
 * Ribbon负载均衡规则类
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule randomRule() {
        return new RandomRule();//随机规则
    }
}
