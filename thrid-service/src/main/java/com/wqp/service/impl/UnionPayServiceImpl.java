package com.wqp.service.impl;

import com.wqp.config.UnionPaySettingConfig;
import com.wqp.service.IUnionPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:26
 **/
@Service("unionPayServiceImpl")
public class UnionPayServiceImpl implements IUnionPayService {

    @Autowired
    private UnionPaySettingConfig unionPaySettingConfig;

    @Override
    public String unionPay() throws Exception {
        return unionPaySettingConfig.getChannelCode() + unionPaySettingConfig.getBuilderPublicKeyStr();
    }
}
