package com.gyc.springcloud.controller;

import com.gyc.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by GYC
 * 2021/2/10 18:39
 */
@RestController
@RequestMapping("/consumer")
public class OrderNacosController {
    //    @Value("${server-url.nacos-user-service}")
    public String SERVER_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/nacos/{string}")
    public String paymentInfo(@PathVariable String string) {
        return restTemplate.getForObject(SERVER_URL + "/payment/nacos/" + string, String.class);
    }
}
