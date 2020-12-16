package com.gyc.springcloud.controller;

import com.gyc.springcloud.entity.CommonResult;
import com.gyc.springcloud.entity.Payment;
import com.gyc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result + "*****");
        if (result > 0) {
            return new CommonResult<>(200, "创建订单成功,server port:"+serverPort, result);
        }
        return new CommonResult<>(444, "创建订单失败,server port:"+serverPort, result);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult<>(200, "查询成功,server port:"+serverPort, result);
        }
        return new CommonResult<>(444, "无查询结果,server port:"+serverPort);
    }

    @GetMapping("/list")
    public CommonResult<List<Payment>> getAllPayments() {
        List<Payment> result = paymentService.getAllPayments();
        if (result != null) {
            return new CommonResult<>(200, "查询成功,server port:"+serverPort, result);
        }
        return new CommonResult<>(444, "无查询结果,server port:"+serverPort);
    }

    @GetMapping("lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
