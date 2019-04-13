package com.wqp.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description 注册中心
 * @Author Wang QiuPeng
 * Date 19/4/13 19:10
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String args[]){
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
