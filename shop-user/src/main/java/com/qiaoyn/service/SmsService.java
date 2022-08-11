package com.qiaoyn.service;

import com.alibaba.fastjson.JSON;
import com.qiao.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 发送短信的服务
 * @author qiaoyanan
 * date:2022/08/11 15:58
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "shop-user", topic = "order-topic")
public class SmsService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        log.info("收到一个订单信息{},接下来发送短信", order);
    }
}
