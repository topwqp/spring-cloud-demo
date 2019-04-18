package com.wqp.user.client.partner.core.client;

import com.wqp.user.client.config.FeignLogConfiguration;
import com.wqp.user.client.partner.core.fallback.BizCoreFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description 调用biz-core
 * @Author Wang QiuPeng
 * Date 19/4/15 20:44
 **/
@FeignClient(name = "biz-core", fallback = BizCoreFallback.class,configuration = {FeignLogConfiguration.class})
public interface BizCoreClient {


    /**
     * 查询账户信息
     * @return
     */
    @RequestMapping(value = "/queryAccountInfo", method = RequestMethod.GET)
    String queryAccountInfo();

}
