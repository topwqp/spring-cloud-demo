package com.wqp.hystrix.fallback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Description
 * Hystrix失败fallBack
 * @Author Wang QiuPeng
 * Date 19/4/14 20:37
 **/
public class FailFallBackCommand extends HystrixCommand<String> {

    private final String name;

    public FailFallBackCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        throw new RuntimeException("this command always fails");
    }

    @Override
    protected String getFallback() {
        return "Fail " + name + " invoke fallback method";
    }
}
