package com.gyc.springcloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * Created by GYC
 * 2021/2/6 10:10
 * 自定义Gateway的Filter
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**************进入MyLogGatewayFilter" + new Date() + "**************");
        //拿到请求参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("**************用户名为null，非法用户**************");
            //给出一个回应 设置status code
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //传给下一个filter
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的优先级顺序，数字越小优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
