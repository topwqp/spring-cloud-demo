package com.wqp.domain.hystrix.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * @Description demo restController
 * @Author Wang QiuPeng
 * Date 19/4/7 16:25
 **/
@RestController
public class  DemoRestController {

    private final  static Random random = new Random();
    /**
     * 当方法执行时间超过100ms时，触发异常
     * @return
     */
    @GetMapping("")
    public String index() throws Exception{
        long executeTime = random.nextInt(200);
        if (executeTime > 100) {
            throw new TimeoutException("method execution is time out");
        }
        return "hello world";
    }

}
