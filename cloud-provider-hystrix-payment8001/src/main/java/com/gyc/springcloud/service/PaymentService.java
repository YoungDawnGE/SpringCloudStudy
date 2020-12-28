package com.gyc.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by GYC
 * 2020/12/8 15:42
 * 可以与Dao一致
 */
@Service
public class PaymentService {
    /**
     * 正常方法
     * @param id 参数
     * @return
     */
    public String paymentInfoOK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoOK() " + "id：" + id+"\t O(∩_∩)O";
    }

    /**
     * 模拟超时
     * @HystrixProperty 这个注解里面的name指定了fallbackMethod方法执行的条件
     * @param id 参数
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) throws InterruptedException {
        int time = 2;//超过3s才会报错
//        int error = 10/0;//fallbackMethod是一切问题的兜底方法,除0错误也会进入此方法
        TimeUnit.SECONDS.sleep(time);
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOut() " + "id：" + id + "\t ┭┮﹏┭┮ 耗时" + time + "s";
    }

    /**
     * 兜底的方法
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfoTimeOutHandler兜底方法() " + "id：" + id+"\t ┭┮﹏┭┮";
    }
}
