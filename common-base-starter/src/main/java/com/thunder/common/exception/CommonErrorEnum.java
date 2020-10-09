package com.thunder.common.exception;

/**
 * @description:
 * @author: lim14905
 * @create: 2020/10/9
 **/
public enum CommonErrorEnum implements CommonErrorInterface {


    G0000("G0000", "Internal Error"),
    G0001("G0001", "请求参数错误"),
    ;
    private String code;
    private String message;
    private String subCode;

    private CommonErrorEnum(String subCode, String message) {
        this.code = subCode;
        this.subCode = subCode;
        this.message = message;
    }

    private CommonErrorEnum(String code, String subCode, String message) {
        this.code = code;
        this.subCode = subCode;
        this.message = message;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getSubCode() {
        return this.subCode;
    }
}
