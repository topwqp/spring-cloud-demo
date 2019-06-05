package com.wqp.domain.config;

import com.wqp.domain.service.ITableShardStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 分表注解
 * @Author Wang QiuPeng
 * @Date 2019-06-05 11:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableShard {
    // 要替换的表名
    String tableName();
    // 对应的分表策略类
    Class<? extends ITableShardStrategy> shardStrategy();
}
