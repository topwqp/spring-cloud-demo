package com.wqp.domain.pattern.observale.guavatest;

import com.google.common.eventbus.EventBus;

/**
 * @Description guava event test
 * @Author Wang QiuPeng
 * Date 19/4/13 17:29
 **/
public class GuavaEventTest {
    public static void main(String args[]){
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("[submit param content]");
    }
}
