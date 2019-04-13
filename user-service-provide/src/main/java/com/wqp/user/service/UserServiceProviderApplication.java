package com.wqp.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Description 提供用户服务启动类
 * @Author Wang QiuPeng
 * Date 19/4/7 17:18
 **/
@EnableHystrix
@SpringBootApplication
public class UserServiceProviderApplication {
    public static void main(String args[]){
        SpringApplication.run(UserServiceProviderApplication.class,args);
    }
}
