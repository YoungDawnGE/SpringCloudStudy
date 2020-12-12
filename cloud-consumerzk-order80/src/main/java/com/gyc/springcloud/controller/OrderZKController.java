package com.gyc.springcloud.controller;

import com.gyc.springcloud.entity.CommonResult;
import com.gyc.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2020/12/12 10:12
 */
@RestController
@Slf4j
public class OrderZKController {
    @Autowired
    private RestTemplate restTemplate;
    public static final String PAYMENT_URL = "http://cloud-payment-service";//用微服务的名字作为地址

    @GetMapping("/consumer/payment/zk")
    public String zkInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
