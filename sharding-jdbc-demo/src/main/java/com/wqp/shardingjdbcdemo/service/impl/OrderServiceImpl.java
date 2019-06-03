package com.wqp.shardingjdbcdemo.service.impl;

import com.wqp.shardingjdbcdemo.common.util.IDGenerateUtil;
import com.wqp.shardingjdbcdemo.dao.OrderItemMapper;
import com.wqp.shardingjdbcdemo.dao.OrderMapper;
import com.wqp.shardingjdbcdemo.entity.*;
import com.wqp.shardingjdbcdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: order service impl
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:37
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public List<Order> getOrder(OrderRequest orderRequest) {
        return orderMapper.getOrder(orderRequest);
    }

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

    @Override
    public void addOrder(OrderVO orderVO) {
        Order order = orderVO.getOrder();
        List<OrderItem> orderItems = orderVO.getOrderItems();
        addSnowId(order, orderItems);

        orderMapper.addOrder(order);
        orderItemMapper.addOrderItems(orderItems);

    }

    @Override
    public List<OrderInfo> getOrderInfo(OrderRequest orderRequest) {
        return orderMapper.getOrderInfo(orderRequest);
    }

    /**
     * 给订单和订单项设置雪花id
     *
     * @author cluo
     * @date 2018/08/03
     * @param order
     * @param orderItems
     */
    private void addSnowId(Order order, List<OrderItem> orderItems) {
        Long snowId = IDGenerateUtil.getSnowId();
        order.setOrderId(snowId);
        for (OrderItem item : orderItems) {
            item.setOrderId(snowId);
        }
    }
}
