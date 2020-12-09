package com.gyc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by GYC
 * 2020/12/8 19:46
 * 前端通用json实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//404,200
    private String  message;
    private T       data;

    //可能data为null，所以我们定义2个参数的构造器
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
