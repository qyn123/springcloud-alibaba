package com.qiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Long oId;//订单id
    private Integer uId;//用户id
    private String userName;//用户名
    private Integer pId;//商品id
    private String pName;//商品名称
    private Double pPrice;//商品单价
    private Integer number;//购买数量
    private String dataBase;
}
