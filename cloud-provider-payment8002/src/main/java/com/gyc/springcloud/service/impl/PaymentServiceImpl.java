package com.gyc.springcloud.service.impl;

import com.gyc.springcloud.dao.PaymentDao;
import com.gyc.springcloud.entity.Payment;
import com.gyc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GYC
 * 2020/12/8 15:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    //@Autowired（用了@Mapper，这里会报错）和@Resource都可以进行依赖注入
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }
}
