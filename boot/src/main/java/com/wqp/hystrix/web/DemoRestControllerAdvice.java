package com.wqp.hystrix.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

/**
 * @Description AOP拦截
 * @Author Wang QiuPeng
 * Date 19/4/7 16:40
 **/
@RestControllerAdvice(assignableTypes = DemoRestController.class)
public class DemoRestControllerAdvice {

    @ExceptionHandler(TimeoutException.class)
    public String faultToleranceTimeOut(Exception e){
        return e.getMessage();
    }
}
