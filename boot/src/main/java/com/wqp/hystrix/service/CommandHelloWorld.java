package com.wqp.hystrix.service;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Description hello word hystrix command
 * @Author Wang QiuPeng
 * Date 19/4/8 13:52
 **/
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }


    @Override
    protected String run() throws Exception {
        return "Hello " + name;
    }


}