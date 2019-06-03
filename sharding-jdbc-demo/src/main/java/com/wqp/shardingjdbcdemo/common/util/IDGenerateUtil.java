package com.wqp.shardingjdbcdemo.common.util;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;

/**
 * @Description: id generate util
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:04
 */
public class IDGenerateUtil {
    public static DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
    private static Integer id = 0;
    public static synchronized Integer getUserId() {
        id++;
        return id;
    }

    public static long getSnowId() {
        return keyGenerator.generateKey().longValue();
    }

}
