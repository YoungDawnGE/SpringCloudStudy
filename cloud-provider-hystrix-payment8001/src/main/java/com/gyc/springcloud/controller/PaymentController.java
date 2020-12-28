package com.gyc.springcloud.controller;

import com.gyc.springcloud.service.PaymentService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GYC
 * 2020/12/8 15:50
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String res = paymentService.paymentInfoOK(id);
        log.info("******* result:" + res + "*******");
        return res;
    }

    @GetMapping("hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) throws InterruptedException {
        String res = paymentService.paymentInfoTimeOut(id);
        log.info("******* result:" + res + "*******");
        return res;
    }
}
