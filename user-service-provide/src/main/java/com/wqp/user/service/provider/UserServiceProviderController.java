package com.wqp.user.service.provider;

import api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description 用户服务提供方
 * @Author Wang QiuPeng
 * Date 19/4/7 17:39
 **/
@RestController
public class UserServiceProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceProviderController.class);

    @Autowired
    private UserService userService;

    private final static Random random = new Random();

    @PostMapping("/user/save")
    public boolean saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/query/all/list")
    public List<User> queryAllUser(){
        return userService.queryAllUser();
    }



    /**
     * 增加超时处理
     * @return
     */
    @HystrixCommand(commandProperties = {
            //设置操作超时时间 100毫秒
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100"),
            //设置fallback方法
    },fallbackMethod = "fallbackFindAll")
    @GetMapping("/user/list")
    public List<User> findAll() throws InterruptedException {

        long executionTime = random.nextInt(200);
        LOG.info("find all user info execution time is {} ms ", executionTime);
        Thread.sleep(executionTime);
        return userService.queryAllUser();
    }

    /**
     * 查询所有用户信息失败回调方法
     * @return
     */
    public List<User> fallbackFindAll(){
        return Collections.emptyList();
    }
}
