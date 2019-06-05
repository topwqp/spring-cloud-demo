package com.wqp.test.hystrix;

import com.wqp.domain.BootApplication;
import com.wqp.domain.hystrix.service.CommandHelloWorld;
import com.wqp.domain.hystrix.service.ObservableCommand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;

import java.util.concurrent.Future;

/**
 * @Description hystrix command test
 * @Author Wang QiuPeng
 * Date 19/4/14 11:23
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BootApplication.class)
public class HystrixCommandTest {
    private static final Logger LOG = LoggerFactory.getLogger(HystrixCommandTest.class);
    @Test
    public void testSynchronous(){
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("World");
        String targetString = commandHelloWorld.execute();
        LOG.info("target result is  :  {} ",targetString);
        Assert.assertEquals("Hello World",targetString);
    }

    @Test
    public void testAsynchronous() throws Exception{
        Assert.assertEquals("Hello World",new CommandHelloWorld("World").queue().get());
    }


    @Test
    public void testAsynchronous2() throws Exception{
        Future<String> future = new CommandHelloWorld("World").queue();
        Assert.assertEquals("Hello World",future.get());
    }


    @Test
    public void testObservable() throws Exception{
        Observable<String> observable = new ObservableCommand("World").toObservable();
        LOG.info("testObservable result is {} ",observable.toBlocking().toFuture().get());

    }


}

