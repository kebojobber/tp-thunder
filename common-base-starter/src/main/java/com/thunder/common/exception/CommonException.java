package com.thunder.common.exception;

/**
 * @description:
 * @author: lim14905
 * @create: 2020/10/9
 **/
public class CommonException extends RuntimeException {

    private CommonErrorInterface errorCodeEnum;
    private String[] params;

    public CommonException(CommonErrorInterface errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
        this.params = new String[]{errorCodeEnum.getCode()};
    }

    public CommonException(CommonErrorInterface errorCodeEnum, String... params) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
        this.params = new String[params.length + 1];
        this.params[0] = errorCodeEnum.getCode();
        System.arraycopy(params, 0, this.params, 1, params.length);
    }

    private CommonException() {
    }

    public CommonErrorInterface getErrorEnum() {
        return this.errorCodeEnum;
    }

    public String[] getParams() {
        return this.params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
