package com.gyc.springcloud.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by GYC
 * 2020/12/8 19:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;//Long对应数据库中的bigint
    private String serial;
}
