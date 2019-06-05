package com.wqp.domain.service.impl;

import com.wqp.domain.service.ITableShardStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 按月分表策略
 * @Author Wang QiuPeng
 * @Date 2019-06-05 11:49
 */

public class MonthTableShardStrategy implements ITableShardStrategy {

    private static final String DATE_PATTERN = "yyyyMM";

    @Override
    public String tableShard(String tableName) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return tableName + "_" + sdf.format(new Date());
    }
}
