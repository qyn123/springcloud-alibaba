package com.qiaoyn.controller;

import com.alibaba.fastjson.JSON;
import com.qiao.entity.Order;
import com.qiao.entity.Product;
import com.qiaoyn.service.OrderService;
import com.qiaoyn.service.ProductFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @author qiaoyanan
 * date:2022/07/16 21:02
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductFeignService productFeignService;

    @GetMapping("/create/order/{pid}")
    public Order create(@PathVariable("pid") Integer pid) {
        //Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
        //ServiceInstance serviceInstance = discoveryClient.getInstances("service-product").get(0);
        //自定义负载均衡算法(随机数)
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        int index = new Random().nextInt(instances.size());
//        ServiceInstance serviceInstance = instances.get(index);
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        log.info("正在调用的端口号是: {}",port);
        //       Product product = restTemplate.getForObject("http://"+host+":"+port+"/product/" + pid, Product.class);
        //基于ribbon的负载均衡(默认轮询)
        //Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
        //基于feign远程调用
        Product product = productFeignService.findByPid(pid);
        if (product.getPId() == -1) {
            Order order = new Order();
            order.setPName("下单失败");
            return order;
        }
        Order order = new Order();
        order.setPId(pid);
        order.setPName(product.getPName());
        order.setPPrice(product.getPPrice());
        order.setNumber(1);
        order.setUserName("tom");
        order.setUId(1);
        orderService.createOrder(order);
        return order;
    }

    /**
     * 基于ribbon的负载均衡(默认使用轮询算法):查询商品信息,查看每次查询哪个库的信息
     * 查询货物信息
     */
    @GetMapping("/get/product/{pid}")
    public Product getProduct(@PathVariable("pid") Integer pid) {
        return restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
    }
}
