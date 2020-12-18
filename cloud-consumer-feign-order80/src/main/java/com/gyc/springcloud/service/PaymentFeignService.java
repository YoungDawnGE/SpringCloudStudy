package com.gyc.springcloud.service;

import com.gyc.springcloud.entity.CommonResult;
import com.gyc.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by GYC
 * 2020/12/17 19:52
 *
 * @FeignClient(调用的服务名称)
 * 8001服务提供者 提供什么接口 这边80的service调用什么接口
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //演示超时调用
    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
