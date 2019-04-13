package com.wqp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:27
 **/
@Configuration
public class UnionPaySettingConfig {
    /**
     * 银联渠道号
     */
    @Value("${unionpay.channelCode}")
    private String channelCode;

    /**
     * 生成公钥字符串，使用生成的公钥对待加密字符串进行加密处理
     */
    @Value("${unionpay.builderPublicKeyStr}")
    private String  builderPublicKeyStr;


    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getBuilderPublicKeyStr() {
        return builderPublicKeyStr;
    }

    public void setBuilderPublicKeyStr(String builderPublicKeyStr) {
        this.builderPublicKeyStr = builderPublicKeyStr;
    }
}
