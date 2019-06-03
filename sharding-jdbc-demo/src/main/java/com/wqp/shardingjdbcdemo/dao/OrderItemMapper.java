package com.wqp.shardingjdbcdemo.dao;

import com.wqp.shardingjdbcdemo.dao.provider.OrderItemMapperProvider;
import com.wqp.shardingjdbcdemo.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:12
 */
@Mapper
public interface OrderItemMapper {
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "orderItemId", column = "order_item_id"),
            @Result(property = "description", column = "description")
    })
    @Select("select * from order_item order by order_id")
    List<OrderItem> getOrderItems();



    @InsertProvider(type = OrderItemMapperProvider.class, method = "insertAll")
    int addOrderItems(@Param("orderItems") List<OrderItem> orderItems);
}
