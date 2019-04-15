package com.wqp.hystrix.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * @Description
 * Hystrix使用了group key把一些命令放在同一个组里面
 * (比如我们系统依赖了外部的Service A和Service B，我们可以创建两个Command Group A、Command Group B，
 * 其中A服务又有m1，m2方法，那么Command Group A又包括了Command Name m1 和Command Name m2)，
 * 然后以组为维度上传监控数据，提供监控大盘，报警。
 * 另外，默认情况下，同一个Command Group下的Command使用相同的Thread-pool，
 * 除非某些Command单独指定了线程池。
 * 如果你创建的HystrixCommand没有显示的指定thread-pool key，那么默认情况下就会使用HystrixCommandGroupKey
 * 逻辑上Command A和B都依赖于外部的user service所以让他们属于同一个组userGroup，
 * 但是为了避免Command A挂了影响Command B，
 * 我们可以给A指定一个单独的HystrixThreadPoolKey。
 * @Author Wang QiuPeng
 * Date 19/4/14 20:26
 **/
public class SetterCommandHelloWorld extends HystrixCommand {

    private String name;

    public SetterCommandHelloWorld(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Example Group"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorld"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldPoll")));
        this.name = name;
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
