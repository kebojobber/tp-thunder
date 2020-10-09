package com.thunder.base.controller;

import com.thunder.base.event.MsgEventPublisher;
import com.thunder.common.api.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: llm
 * @create: 2020/9/3
 **/
@RestController
@RequestMapping("/base")
public class ProductController {


    @Autowired
    MsgEventPublisher msgEventPublisher;

    @GetMapping("/get")
    public JsonResult<Object> getById() {
        msgEventPublisher.publish("hello word");
        return JsonResult.success();
    }

}
