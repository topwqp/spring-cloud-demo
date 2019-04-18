package com.wqp.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description core 启动类
 * @Author Wang QiuPeng
 * Date 19/4/13 23:21
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CoreApplication {

    public static void main(String args[]){
       SpringApplication.run(CoreApplication.class,args);
    }
}
