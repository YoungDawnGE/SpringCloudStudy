package com.gyc.springcloud.lb;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by GYC
 * 2020/12/16 8:37
 * 自定义均衡负载
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncreament() {
        int current;
        int next;
//        RoundRobinRule
        //自旋锁
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("--------next:"+next+"--------");
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = getAndIncreament() % instances.size();
        return instances.get(index);
    }
}
