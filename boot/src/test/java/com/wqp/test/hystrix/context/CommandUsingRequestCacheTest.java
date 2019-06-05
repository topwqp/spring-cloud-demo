package com.wqp.test.hystrix.context;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.wqp.domain.BootApplication;
import com.wqp.domain.hystrix.context.CommandUsingRequestCache;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Description 请求上下文可以添加过滤器，在启动时候，加载一个上下文
 * @Author Wang QiuPeng
 * Date 19/4/14 21:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BootApplication.class)
public class CommandUsingRequestCacheTest {

    @Test
    public void testWithCacheHits() throws Exception{
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        try{
            CommandUsingRequestCache firstCommand = new CommandUsingRequestCache(2);
            CommandUsingRequestCache secondCommand = new CommandUsingRequestCache(2);
            Assert.assertTrue(firstCommand.execute());
            Assert.assertFalse(firstCommand.isResponseFromCache());
            Assert.assertTrue(secondCommand.execute());
            Assert.assertTrue(secondCommand.isResponseFromCache());
        }finally {
            context.shutdown();
        }

        //start a new request context
        context = HystrixRequestContext.initializeContext();
        try {
            CommandUsingRequestCache thirdCommand = new CommandUsingRequestCache(2);
            Assert.assertTrue(thirdCommand.execute());
            Assert.assertFalse(thirdCommand.isResponseFromCache());
        }finally {
            context.shutdown();
        }
    }




}
