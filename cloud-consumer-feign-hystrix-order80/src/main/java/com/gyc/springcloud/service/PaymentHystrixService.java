package com.gyc.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by GYC
 * 2020/12/23 20:36
 * 把cloud-provider-hystrix-payment8001中controller能提供的方法拿过来
 */
@Component
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentHystrixService {
    @GetMapping("payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
