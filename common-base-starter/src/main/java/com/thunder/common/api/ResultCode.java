package com.thunder.common.api;

/**
 * @description:
 * @author: liumiao
 * @create: 2020/9/8
 **/
public enum ResultCode {

    //成功
    SUCCESS("200", "操作成功"),
    //失败
    FAIL("500", "操作失败"),
    //参数校验失败
    VALIDATE_FAILED("404", "参数检验失败"),
    //token失效
    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    //权限不足
    FORBIDDEN("403", "没有相关权限");

    private String code;
    private String message;


    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }
}
