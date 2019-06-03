package com.wqp.shardingjdbcdemo.dao;

import com.wqp.shardingjdbcdemo.dao.provider.OrderMapperProvider;
import com.wqp.shardingjdbcdemo.entity.Order;
import com.wqp.shardingjdbcdemo.entity.OrderInfo;
import com.wqp.shardingjdbcdemo.entity.OrderRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:12
 */
@Mapper
public interface OrderMapper {
    @Results(id = "order", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "description", column = "description"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("select * from order order by order_id")
    List<Order> getOrders();

    @ResultMap(value = "order")
    @SelectProvider(type = OrderMapperProvider.class, method = "getOrder")
    List<Order> getOrder(OrderRequest orderRequest);

    @Insert("insert into order(order_id, user_id, description) " +
            "values(#{order.orderId}, #{order.userId}, #{order.description})")
    int addOrder(@Param("order") Order order);

    @Results(id = "orderInfo", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderItemId", column = "order_item_id"),
            @Result(property = "orderDescription", column = "order_description"),
            @Result(property = "orderItemDescription", column = "order_item_description"),
            @Result(property = "createTime", column = "create_time")
    })
    @SelectProvider(type = OrderMapperProvider.class, method = "getOrderInfo")
    List<OrderInfo> getOrderInfo(OrderRequest orderRequest);
}
