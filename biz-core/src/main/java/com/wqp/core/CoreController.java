package com.wqp.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:18
 **/
@RestController
public class CoreController {


    @RequestMapping(value = "/queryAccountInfo",method = RequestMethod.POST)
    public String queryAccountInfo() throws Exception{
      return "111111";
    }
}
