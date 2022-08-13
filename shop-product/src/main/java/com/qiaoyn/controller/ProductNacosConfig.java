package com.qiaoyn.controller;

import com.alibaba.cloud.nacos.NacosConfigAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaoyanan
 * date:2022/08/13 14:26
 * 读取nacos配置,自动刷新
 * @RefreshScope:动态刷新
 */
@RestController
@RefreshScope
public class ProductNacosConfig {

    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Value("${config.appName}")
    private String appName;
    @Value("${config.env}")
    private String env;

    @GetMapping("/test1")
    public String test1() {
        return applicationContext.getEnvironment().getProperty("config.appName");
    }


    @GetMapping("/test2")
    public String test2() {
        return appName;
    }

    @GetMapping("/test3")
    public String test3() {
        return env;
    }
}
