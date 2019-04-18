package com.wqp.user.client.web;

import com.wqp.user.client.partner.core.client.BizCoreClient;
import com.wqp.user.client.partner.user.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 综合测试
 * @Author Wang QiuPeng
 * Date 19/4/15 20:56
 **/
@RestController
public class HystrixFeignRibbonController {

    @Autowired
    private BizCoreClient bizCoreClient;

    @Autowired
    private UserServiceClient userServiceClient;


    @GetMapping("/queryAccountInfo")
    public String queryAccountInfo(){
       return bizCoreClient.queryAccountInfo();
    }


    @GetMapping("/queryUserInfo")
    public String queryUserInfo(){
        return userServiceClient.queryUserInfo();
    }

}
