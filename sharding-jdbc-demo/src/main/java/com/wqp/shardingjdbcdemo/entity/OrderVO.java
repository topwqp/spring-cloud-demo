package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description: order vo
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:27
 */
@Getter
@Setter
public class OrderVO {
    private Order order;
    private List<OrderItem> orderItems;
}
