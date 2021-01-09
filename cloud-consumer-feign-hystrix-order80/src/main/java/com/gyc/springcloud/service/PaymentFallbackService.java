package com.gyc.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by GYC
 * 2021/1/9 9:40
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "PaymentFallbackService: fallback-paymentInfoOK /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "PaymentFallbackService: fallback-paymentInfoTimeout /(ㄒoㄒ)/~~";
    }
}
