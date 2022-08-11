package com.qiaoyn.controller;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author qiaoyanan
 * date:2022/08/11 10:38
 */
public class RocketMqReceiveTest {
    public static void main(String[] args) throws MQClientException {
        //1. 创建消息消费者, 指定消费者所属的组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myconsumer-group");
        //2. 指定Nameserver地址
        consumer.setNamesrvAddr("127.0.0.1:9876");
        //3. 指定消费者订阅的主题和标签
        consumer.subscribe("myTag", "*");
        //4. 设置回调函数，编写处理消息的方法
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.println("Receive New Messages: " + msgs);
            //返回消费状态
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        //5. 启动消息消费者
        consumer.start();
        System.out.println("Consumer Started.");
    }
}
