package com.wqp.user.client.web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description restTemplate 直接调用
 * @Author Wang QiuPeng
 * Date 19/4/13 22:06
 **/
@RestController
public class RestTemplateRequestController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-provider.host}")
    private String serviceProviderHost;

    @Value("${service-provider.port}")
    private Integer serviceProviderPort;

    @Value("${service-provider.name}")
    private String serviceProviderName;

    @GetMapping("/testRestInvoke")
    public String index(){
        User user = new User.Builder().userId(5).username("Tom").build();
        String requestUrl = "http://" + serviceProviderName + "/user/save";
        return restTemplate.postForObject(requestUrl,user,String.class);
    }
}
