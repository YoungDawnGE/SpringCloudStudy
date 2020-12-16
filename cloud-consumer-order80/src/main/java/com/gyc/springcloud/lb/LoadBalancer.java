package com.gyc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by GYC
 * 2020/12/16 8:33
 * 自定义的负载均衡的接口
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> instances);
}
