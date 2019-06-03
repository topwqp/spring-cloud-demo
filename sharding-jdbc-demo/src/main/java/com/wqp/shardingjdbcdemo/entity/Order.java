package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:19
 */
@Getter
@Setter
public class Order {
    private Long orderId;
    private Integer userId;
    private String description;
    private Date createTime;
}
