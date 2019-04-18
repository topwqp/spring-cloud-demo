package com.wqp.user.client.partner.user.fallback;

import com.wqp.user.client.partner.user.client.UserServiceClient;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/15 20:50
 **/
@Service
public class UserServiceFallback implements UserServiceClient {
    @Override
    public String queryUserInfo() {
        return "query user info fail";
    }
}
