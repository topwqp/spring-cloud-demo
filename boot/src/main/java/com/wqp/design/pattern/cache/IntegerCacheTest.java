package com.wqp.design.pattern.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 享元模式demo
 * @Author Wang QiuPeng
 * Date 19/4/18 03:39
 **/
public class IntegerCacheTest {

    private static final Logger LOG = LoggerFactory.getLogger(IntegerCacheTest.class);

    public static void main(String args[]){
        Integer  a = 126;
        Integer  b = 126;
        boolean result = a == b;
        LOG.info("first compare == result is {} ",result);
        boolean equalResult = a.equals(b);
        LOG.info("first equals result is {}",equalResult);


        Integer a1 = 128;
        Integer b1 = 128;
        boolean compareResult = a1 == b1;
        LOG.info("second == result is {} ",compareResult);
        boolean equalsCompareResult = a1.equals(b1);
        LOG.info("second equals result  is {} ",equalsCompareResult);
    }
}
