package com.qiaoyn.service.impl;

import com.alibaba.fastjson.JSON;
import com.qiao.entity.Order;
import com.qiao.entity.Product;
import com.qiaoyn.dao.OrderDao;
import com.qiaoyn.service.ProductFeignService;
import com.qiaoyn.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaoyanan
 * date:2022/09/09 10:52
 */
@Slf4j
@Service
public class OrderServiceImpl4 {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductFeignService productFeignService;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Autowired
    private ProductService productService;

    @GlobalTransactional
    public Order createOrder(Integer pid) {
        //1 调用商品微服务,查询商品信息
        Product product = productFeignService.findByPid(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
        //2 下单(创建订单)
        Order order = new Order();
        order.setUId(1);
        order.setUserName("测试用户");
        order.setPId(pid);
        order.setPName(product.getPName());
        order.setPPrice(product.getPPrice());
        order.setNumber(1);
        orderDao.createOrder(order);
        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        //3 扣库存
        productService.reduceInventory(pid, order.getNumber());
        //4 向mq中投递一个下单成功的消息
        rocketMQTemplate.convertAndSend("order-topic", order);
        return order;
    }
}
