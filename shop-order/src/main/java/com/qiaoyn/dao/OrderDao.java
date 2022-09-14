package com.qiaoyn.dao;

import com.qiao.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qiaoyanan
 * date:2022/07/16 20:57
 */
@Mapper
public interface OrderDao {

    @Insert("INSERT INTO `order`(`u_id`, `user_name`, `p_id`, `p_name`, `p_price`, `number`,`data_base`) VALUES (#{uId}, #{userName}, #{pId}, #{pName}, #{pPrice}, #{number},#{dataBase})")
    void createOrder(Order order);
}
