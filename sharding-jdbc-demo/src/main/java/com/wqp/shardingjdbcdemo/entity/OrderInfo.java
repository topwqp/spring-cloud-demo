package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:20
 */
@Getter
@Setter
public class OrderInfo {
    private Long orderId;
    private Integer userId;
    private Integer orderItemId;
    private String orderDescription;
    private String orderItemDescription;
    private Date createTime;
}
