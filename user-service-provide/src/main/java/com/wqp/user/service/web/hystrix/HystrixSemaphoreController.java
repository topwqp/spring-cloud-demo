package com.wqp.user.service.web.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description hystrix semaphore test
 * Caused by: com.netflix.hystrix.exception.HystrixRuntimeException: TestCommand fallback execution rejected
 * This means that too many fallbacks were executing concurrently. Since the goal of Hystrix is to protect application threads,
 * and fallbacks may run on the caller thread, Hystrix needs to limit the amount of concurrent fallbacks. Whenever this situation occurs,
 * the fallback is not run, and an exception is returned to the caller.
 * In general, the purpose of a fallback is to provide substitute work that is less costly than the original work. Here are 2 options for proceeding:
 * @Author Wang QiuPeng
 * Date 19/4/14 15:33
 **/
@RestController
public class HystrixSemaphoreController {

    private static final Logger LOG = LoggerFactory.getLogger(HystrixSemaphoreController.class);
    
    /**
     * 限流策略：信号量方式
     * @param userId
     * @param username
     * @return
     * @throws Exception
     */
    @HystrixCommand(
            commandKey="registerUserSemaphore",
            commandProperties= {
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),
                    @HystrixProperty(name="execution.isolation.semaphore.maxConcurrentRequests", value="1")
            },
            fallbackMethod = "registerUserFallbackMethod4semaphore"
        )
    @RequestMapping("/registerUserSemaphore")
    public String registerUserSemaphore(@RequestParam("userId")Integer userId,
                               @RequestParam("username")String username) throws Exception {
        LOG.info("semaphore create user success");
        return "semaphore create user success";
    }

    public String registerUserFallbackMethod4semaphore(@RequestParam("userId")Integer userId,
                                                       @RequestParam("username")String username) throws Exception {
        LOG.info("hystrix semaphore fallback");
        return "hystrix semaphore fallback";
    }
}
