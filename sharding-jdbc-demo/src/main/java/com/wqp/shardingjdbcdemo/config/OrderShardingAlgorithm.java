package com.wqp.shardingjdbcdemo.config;

import com.wqp.shardingjdbcdemo.common.constant.TimeConstant;
import com.wqp.shardingjdbcdemo.common.util.DateUtil;
import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * @Description:
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:08
 */
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    public OrderShardingAlgorithm(){}

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long id = preciseShardingValue.getValue();
        // 获取时间（年月日）
        Long time = id >> 22;
        time += TimeConstant.START_UNIX_TIME;
        String timeString = DateUtil.unixToDateString(time, TimeConstant.DATE_FORMAT_YEAR_MONTH);

        for (String each : collection) {
            if (each.endsWith(timeString)) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
