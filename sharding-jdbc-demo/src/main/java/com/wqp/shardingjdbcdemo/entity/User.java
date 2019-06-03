package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: user
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:28
 */
@Getter
@Setter
public class User {
    private Integer userId;
    private String name;
    private Integer age;
    private String address;
}
