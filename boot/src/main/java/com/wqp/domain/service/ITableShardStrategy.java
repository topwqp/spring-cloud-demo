package com.wqp.domain.service;

/**
 * @Description: 分表策略接口
 * @Author Wang QiuPeng
 * @Date 2019-06-05 11:48
 */
public interface ITableShardStrategy {

    String tableShard(String tableName);

}
