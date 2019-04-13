package com.wqp.design.pattern.observale.guavatest;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 17:25
 **/
public class GuavaEvent {
    private static final Logger LOG = LoggerFactory.getLogger(GuavaEvent.class);
    @Subscribe
    public void subscribe(String str){
        LOG.info("execute subscribe event param is {} ",str);
    }
}
