package com.wqp.service;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:25
 **/
public interface IUnionPayService {

    /**
     * 银联支付接口
     * @return
     * @throws Exception
     */
     String unionPay() throws Exception;
}
