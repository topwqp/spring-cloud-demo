package com.wqp.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @Description core 启动类
 * @Author Wang QiuPeng
 * Date 19/4/13 23:21
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CoreApplication {

    public static void main(String args[]){

        String value = "yc_log={\"no\":\"460110538842494\"}}&appkey=yiche&enc=0&ltype=view&";
        String keyPreFlag = "yc_log";

        String[]  array = value.split("\\&");
        Arrays.stream(array).filter(single -> single.indexOf(keyPreFlag)>0).forEach(s -> System.out.println(s));
        for (String s : array){
            if (s.indexOf(keyPreFlag) > 0){
                System.out.println(s);
            }
        }
       SpringApplication.run(CoreApplication.class,args);
    }
}
