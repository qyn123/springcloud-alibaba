package com.qiaoyn.controller;

import com.qiao.entity.Order;
import com.qiaoyn.service.impl.OrderServiceImpl4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaoyanan
 * date:2022/09/09 10:49
 */
@RestController
@Slf4j
public class OrderController4 {

    @Autowired
    private OrderServiceImpl4 orderService;

    //下单
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        return orderService.createOrder(pid);
    }
}
