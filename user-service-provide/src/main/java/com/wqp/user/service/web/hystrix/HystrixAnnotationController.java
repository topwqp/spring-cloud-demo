package com.wqp.user.service.web.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @Description hystrix command test
 * @Author Wang QiuPeng
 * Date 19/4/14 15:25
 **/
@RestController
public class HystrixAnnotationController {

    private static final Logger LOG = LoggerFactory.getLogger(HystrixAnnotationController.class);

    /**
     * 超时降级
     * @param userId
     * @param username
     * @return
     * @throws Exception
     */
    @HystrixCommand(
            commandKey = "registerUser",
            commandProperties = {
                    @HystrixProperty(name="execution.timeout.enabled", value="true"),
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000"),
            },
            fallbackMethod = "registerUserFallbackMethod4Timeout"
    )

    @RequestMapping("/registerUser")
    public String registerUser(@RequestParam("userId")Integer userId,
                               @RequestParam("username")String username) throws Exception {
        LOG.info("create user success");
        return "create user success";
    }



    public String registerUserFallbackMethod4Timeout(@RequestParam("userId")Integer userId,
                                                     @RequestParam("username")String username) throws Exception {
        LOG.info("hystrix time out fallback");
        return "hystrix time out fallback";
    }

}
