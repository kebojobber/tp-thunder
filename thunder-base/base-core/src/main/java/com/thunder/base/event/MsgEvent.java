package com.thunder.base.event;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/7
 **/
public class MsgEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String message;

    public MsgEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
