package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:20
 */
@Getter
@Setter
public class OrderItem {
    private Long orderId;
    private Integer orderItemId;
    private Integer userId;
    private String description;
}
