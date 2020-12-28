package com.gyc.springcloud.controller;

import com.gyc.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GYC
 * 2020/12/23 20:36
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String res = paymentHystrixService.paymentInfoOK(id);
        log.info("******* result:" + res + "*******");
        return res;
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String res = paymentHystrixService.paymentInfoTimeout(id);
        log.info("******* result:" + res + "*******");
        return res;
    }


    /**
     * 客户端也可以写一个服务降级 1500ms超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("consumer/payment/hystrix/timeout2/{id}")
    public String paymentInfoTimeout2(@PathVariable("id") Integer id) {
        String res = paymentHystrixService.paymentInfoTimeout(id);
        log.info("******* result:" + res + "*******");
        return res;
    }

    private String paymentInfoTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙，请稍后再试";
    }



}
