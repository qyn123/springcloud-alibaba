package com.qiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer uId;//主键
    private String userName;//用户名
    private String passWord;//密码
    private String phone;//手机号
    private String dataBase;
}
