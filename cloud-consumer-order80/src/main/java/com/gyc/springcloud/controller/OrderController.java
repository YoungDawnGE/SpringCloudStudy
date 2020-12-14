package com.gyc.springcloud.controller;

import com.gyc.springcloud.entity.CommonResult;
import com.gyc.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by GYC
 * 2020/12/8 19:14
 *
 *  !RestTemplate
 * 客户端浏览器只能发GetMapping请求,
 * 其内部对远程的API接口进行了调用
 */
@RestController
@Slf4j
public class OrderController {

    //或者@Resource
    @Autowired
    private RestTemplate restTemplate;
//    public static final String PAYMENT_URL = "http://localhost:8001";//单机版
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";//用微服务的名字作为地址

    //postForObject、getForObject方法
    //虽然表面上是get请求，但是内部是post请求
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    //postForEntity、getForEntity方法
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }
}
