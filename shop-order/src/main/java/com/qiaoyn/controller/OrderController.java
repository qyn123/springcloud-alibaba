package com.qiaoyn.controller;

import com.qiao.entity.Order;
import com.qiao.entity.Product;
import com.qiaoyn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiaoyanan
 * date:2022/07/16 21:02
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/create/order/{pid}")
    public void create(@PathVariable("pid") Integer pid){
        //Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        ServiceInstance serviceInstance = discoveryClient.getInstances("service-product").get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        Product product = restTemplate.getForObject("http://"+host+":"+port+"/product/" + pid, Product.class);
        Order order = new Order();
        order.setPId(pid);
        assert product != null;
        order.setPName(product.getPName());
        order.setPPrice(product.getPPrice());
        order.setNumber(1);
        order.setUserName("tom");
        order.setUId(1);
        orderService.createOrder(order);
    }
}
