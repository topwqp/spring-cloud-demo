package com.wqp.user.client.partner.user.client;

import com.wqp.user.client.config.FeignLogConfiguration;
import com.wqp.user.client.partner.user.fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/15 20:48
 **/
@FeignClient(name = "user-service-provider", fallback = UserServiceFallback.class,configuration = {FeignLogConfiguration.class})
public interface UserServiceClient {
    /**
     * 查询账户信息
     * @return
     */
    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.GET)
    String queryUserInfo();
}
