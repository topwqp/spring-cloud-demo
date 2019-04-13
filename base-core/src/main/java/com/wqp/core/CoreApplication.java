package com.wqp.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:21
 **/
@SpringBootApplication
@ComponentScan("com.wqp")
public class CoreApplication {

    public static void main(String args[]){
        SpringApplication.run(CoreApplication.class,args);
    }
}
