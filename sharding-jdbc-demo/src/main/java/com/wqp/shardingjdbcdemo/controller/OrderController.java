package com.wqp.shardingjdbcdemo.controller;



import com.wqp.shardingjdbcdemo.entity.Order;
import com.wqp.shardingjdbcdemo.entity.OrderInfo;
import com.wqp.shardingjdbcdemo.entity.OrderRequest;
import com.wqp.shardingjdbcdemo.entity.OrderVO;
import com.wqp.shardingjdbcdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: order controller
 * @Author Wang QiuPeng
 * @Date 2019-06-03 11:59
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public List<Order> getOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.getOrder(orderRequest);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public void addOrder(@RequestBody OrderVO orderVo) {
        orderService.addOrder(orderVo);
    }

    @RequestMapping(value = "/orderInfo", method = RequestMethod.POST)
    public List<OrderInfo> getOrderInfo(@RequestBody OrderRequest orderRequest) {
        return orderService.getOrderInfo(orderRequest);
    }
}
