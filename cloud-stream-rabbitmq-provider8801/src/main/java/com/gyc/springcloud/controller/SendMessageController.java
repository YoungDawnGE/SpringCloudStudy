package com.gyc.springcloud.controller;

import com.gyc.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GYC
 * 2021/2/9 8:03
 */
@RestController
@RequestMapping("/stream")
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @RequestMapping("send")
    public String sendMsg() {
        return messageProvider.send();
    }
}
