package com.wqp.shardingjdbcdemo.service;

import com.wqp.shardingjdbcdemo.entity.Order;
import com.wqp.shardingjdbcdemo.entity.OrderInfo;
import com.wqp.shardingjdbcdemo.entity.OrderRequest;
import com.wqp.shardingjdbcdemo.entity.OrderVO;

import java.util.List;

/**
 * @Description: order service
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:34
 */
public interface OrderService {

    List<Order> getOrder(OrderRequest orderRequest);

    List<Order> getOrders();

    void addOrder(OrderVO orderVo);

    List<OrderInfo> getOrderInfo(OrderRequest orderRequest);
}
