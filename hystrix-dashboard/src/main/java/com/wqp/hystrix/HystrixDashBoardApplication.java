package com.wqp.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description dashboard 启动类
 * @Author Wang QiuPeng
 * Date 19/4/7 20:45
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApplication {

    public static void main(String args[]){
        SpringApplication.run(HystrixDashBoardApplication.class,args);
    }

}
