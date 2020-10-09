package com.thunder.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: liumiao
 * @create: 2020/9/8
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {

    private long code;
    private String message;
    private T data;

    public static <T> JsonResult<T> success() {
        return new JsonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> JsonResult<T> success(T data, String message) {
        return new JsonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> JsonResult<T> failed(IErrorCode errorCode) {
        return new JsonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> JsonResult<T> failed(IErrorCode errorCode, String message) {
        return new JsonResult<T>(errorCode.getCode(), message, null);
    }

    public static <T> JsonResult<T> failed(String message) {
        return new JsonResult<T>(ResultCode.FAIL.getCode(), message, null);
    }

    public static <T> JsonResult<T> failed() {
        return failed(ResultCode.FAIL);
    }

    public static <T> JsonResult<T> unauthorized() {
        return new JsonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    public static <T> JsonResult<T> validateFail(String message) {
        return new JsonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }


    public static <T> JsonResult<T> forbidden() {
        return new JsonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);
    }

}
