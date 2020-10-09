package com.thunder.base.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 定义一个事件监听者, 实现ApplicationListener接口，重写 onApplicationEvent() 方法；
 * @Component
 * @author: liumiao
 * @create: 2020/9/7
 **/
@Component
public class MsgEventListener implements ApplicationListener<MsgEvent> {

    @Override
    public void onApplicationEvent(MsgEvent msgEvent) {
        String msg = msgEvent.getMessage();
        System.out.println("接收到的信息是：" + msg);
    }
}
