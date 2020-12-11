package com.gyc.springcloud.dao;

import com.gyc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GYC
 * 2020/12/8 14:56
 */
//用了MyBatis之后应该用@Mapper，而@Repository可能在插入的时候会出问题
@Mapper
public interface PaymentDao {
    //写
    int create(Payment payment);

    //读：按id读、全部读、分页读
    Payment getPaymentById(@Param("id") Long id);

    List<Payment> getAllPayments();
}
