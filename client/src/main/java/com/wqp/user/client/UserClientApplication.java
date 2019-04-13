package com.wqp.user.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 客户端服务
 * @Author Wang QiuPeng
 * Date 19/4/13 13:40
 **/
@SpringBootApplication
@RibbonClients({
        @RibbonClient(name = "user-service-provider")
})
@EnableDiscoveryClient
public class UserClientApplication {
    public static void main(String args[]){
        SpringApplication.run(UserClientApplication.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
