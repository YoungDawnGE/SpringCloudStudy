package com.gyc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GYC
 * 2021/2/10 17:34
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/nacos/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string + ", port:" + port;
    }
}
