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
 * @Author Wang QiuPeng
 * Date 19/4/14 15:31
 **/
@RestController
public class HystrixThreadPoolController {

    private static final Logger LOG = LoggerFactory.getLogger(HystrixThreadPoolController.class);

    /**
     * 限流策略：线程池方式
     * @param userId
     * @param username
     * @return
     * @throws Exception
     */
	@HystrixCommand(
				commandKey = "registerUserThreadPool",
				commandProperties = {
						@HystrixProperty(name="execution.isolation.strategy", value="THREAD")
				},
				threadPoolKey = "registerUserThreadPool",
				threadPoolProperties = {
						@HystrixProperty(name="coreSize", value="1"),
                        @HystrixProperty(name="maximumSize", value="1"),
						@HystrixProperty(name="maxQueueSize", value="200"),
						@HystrixProperty(name="queueSizeRejectionThreshold", value="30")
				},
				fallbackMethod="registerUserFallbackMethod4Thread"
			)
    @RequestMapping("/registerUserThreadPool")
    public String registerUserThreadPool(@RequestParam("userId")Integer userId,
                               @RequestParam("username")String username) throws Exception {
	    LOG.info("thread pool create user success");
        return "create user success";
    }

    public String registerUserFallbackMethod4Thread(@RequestParam("userId")Integer userId,
                                                   @RequestParam("username")String username) throws Exception {
        LOG.info("hystrix threadPool fall back");
        return "hystrix threadPool fall back";
    }

}
