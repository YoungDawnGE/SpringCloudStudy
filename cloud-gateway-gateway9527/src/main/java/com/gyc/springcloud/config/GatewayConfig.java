package com.gyc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by GYC
 * 2021/1/24 22:28
 *      way1 通过yaml配置gateway路由转发
 * 本例  way2 通过配置类的方式 实现gateway路由转发
 *
 */
@Configuration
public class GatewayConfig {
    //自定义路由
    //通过9527访问/internet 映射到 http://news.baidu.com/internet
    @Bean
    public RouteLocator myCustomRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gyc_route_1",
                        r -> r.path("/internet").uri("http://news.baidu.com/internet")).build();
    }
}
