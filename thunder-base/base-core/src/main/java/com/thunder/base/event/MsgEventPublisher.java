package com.thunder.base.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description: 发布事件，可以通过ApplicationEventPublisher  的 publishEvent() 方法发布消息。
 * @author: liumiao
 * @create: 2020/9/7
 **/
@Component
public class MsgEventPublisher {

    @Autowired
    ApplicationContext applicationContext;


    public void publish(String message) {
        //发布事件
        applicationContext.publishEvent(new MsgEvent(this, message));
    }


}
