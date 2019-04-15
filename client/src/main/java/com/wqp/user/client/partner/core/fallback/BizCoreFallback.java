package com.wqp.user.client.partner.core.fallback;


import com.wqp.user.client.partner.core.client.BizCoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Description biz-core服务降级
 * @Author Wang QiuPeng
 * Date 19/4/15 20:45
 **/
@Service
public class BizCoreFallback implements BizCoreClient {

    private static final Logger LOG = LoggerFactory.getLogger(BizCoreFallback.class);

    @Override
    public String queryAccountInfo() {
        LOG.error("invoke biz core query account info fail ...");
        return "query account info fail ";
    }
}
