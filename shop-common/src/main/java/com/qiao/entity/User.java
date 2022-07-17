package com.qiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiaoyanan
 * date:2022/07/16 17:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uId;//主键
    private String userName;//用户名
    private String passWord;//密码
    private String phone;//手机号
}
