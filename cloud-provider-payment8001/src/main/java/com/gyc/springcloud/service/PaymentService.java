package com.gyc.springcloud.service;

import com.gyc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GYC
 * 2020/12/8 15:42
 * 可以与Dao一致
 */
public interface PaymentService {
    //写
    int create(Payment payment);

    //读：按id读、全部读、分页读
    Payment getPaymentById(@Param("id") Long id);

    List<Payment> getAllPayments();

}
