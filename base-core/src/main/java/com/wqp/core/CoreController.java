package com.wqp.core;

import com.wqp.service.IUnionPayService;
import com.wqp.service.impl.UnionPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 23:18
 **/
@RestController
public class CoreController {

    @Autowired
    public UnionPayServiceImpl unionPayService;

    @GetMapping("/test")
    public String getValue() throws Exception{
      return "111111" + unionPayService.unionPay();
    }
}
