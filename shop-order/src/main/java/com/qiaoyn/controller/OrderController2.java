package com.qiaoyn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试sentinel
 * java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=127.0.0.1:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.7.0.jar
 * @author qiaoyanan
 * date:2022/07/22 14:00
 * 关于sentinel启动发现dashboard页面未发现注册的服务:
 * https://blog.csdn.net/qq_40117702/article/details/122258243
 */
@Slf4j
@RestController
public class OrderController2 {
    int i = 0;

//    @Autowired
//    private OrderServiceImpl3 orderServiceImpl3;

    @RequestMapping("/order/message1")
    public String message1() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        //orderServiceImpl3.message();
        return "message1:"+ System.currentTimeMillis();
    }

    @RequestMapping("/order/message2")
    public String message2() {
        //orderServiceImpl3.message();
        return "message2:"+ System.currentTimeMillis();
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String name,Integer age) {
        return "message3:"+ System.currentTimeMillis() + "name="+name + ",age="+age;
    }


    @RequestMapping("/order/message4")
    public String message4(String name) {
        System.out.println(name);
        return "message4:"+ System.currentTimeMillis();
    }
}
