package com.qiaoyn.service.impl;

import com.qiao.entity.Order;
import com.qiaoyn.dao.OrderDao;
import com.qiaoyn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaoyanan
 * date:2022/07/16 21:11
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }
}
