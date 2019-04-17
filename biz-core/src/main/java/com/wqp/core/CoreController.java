package com.wqp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description core service provide
 * @Author Wang QiuPeng
 * Date 19/4/13 23:18
 **/
@RestController
public class CoreController {

    private static final Logger LOG = LoggerFactory.getLogger(CoreController.class);

    @RequestMapping(value = "/queryAccountInfo",method = RequestMethod.POST)
    public String queryAccountInfo() throws Exception{
      Thread.sleep(3000);
      LOG.info("core  query account info  invoked");
      return "111111";
    }
}
