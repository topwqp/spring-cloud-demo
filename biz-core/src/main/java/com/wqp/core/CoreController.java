package com.wqp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description core service provide
 * @Author Wang QiuPeng
 * Date 19/4/13 23:18
 **/
@RestController
public class CoreController {

    private static final Logger LOG = LoggerFactory.getLogger(CoreController.class);

    @RequestMapping(value = "/queryAccountInfo",method = RequestMethod.GET)
    public String queryAccountInfo() throws Exception{
      Thread.sleep(3000);
      LOG.info("core  query account info  invoked");
      return "111111";
    }

    @RequestMapping(value = "/mockOutOfMemory",method = RequestMethod.GET)
    public void mockOutOfMemory() throws Exception{

        LOG.info("test outOfMemory   invoked");
        while (true){
            Test  test = new Test();
            byte[]  bytes = new byte[1024*1024];
            test.setName(new String(bytes));
            List<Test> testList = new ArrayList<>();
            testList.add(test);

        }

    }

    public static  class  Test{

        private String name ;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}
