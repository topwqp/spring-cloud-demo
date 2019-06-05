package com.wqp.test.hystrix.fallback;

import com.wqp.domain.BootApplication;
import com.wqp.domain.hystrix.fallback.FailFallBackCommand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/14 20:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BootApplication.class)
public class FallbackTest {

    @Test
    public void testFallback() throws Exception{
        Assert.assertEquals("Fail Hello invoke fallback method",new FailFallBackCommand("Hello").execute());

    }
}
