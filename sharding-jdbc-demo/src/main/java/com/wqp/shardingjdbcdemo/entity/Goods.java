package com.wqp.shardingjdbcdemo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: goods
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:19
 */
@Getter
@Setter
public class Goods {
    private Integer goodsId;
    private String name;
    private Integer type;
}
