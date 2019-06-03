package com.wqp.shardingjdbcdemo.dao.provider;

import com.wqp.shardingjdbcdemo.entity.OrderItem;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @Description: user mapper provider
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:14
 */
public class UserMapperProvider {
    public String insertAll(Map map) {
        List<OrderItem> orderItems = (List<OrderItem>) map.get("users");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into user ");
        sb.append("(user_id, name, age, address) ");
        sb.append("values ");
        MessageFormat mf = new MessageFormat("(#'{'users[{0}].userId}, #'{'users[{0}].name}, #'{'users[{0}].age}, #'{'users[{0}].address})");
        for (int i = 0; i < orderItems.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < orderItems.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
