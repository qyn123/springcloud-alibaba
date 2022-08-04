package com.qiaoyn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaoyanan
 * date:2022/08/03 15:45
 */
@Slf4j
@RestController
@RequestMapping("/shop-order")
public class OrderController3 {

    @RequestMapping("/order/message")
    public String message3() {
        return "message3:"+ System.currentTimeMillis();
    }
}
