package com.thunder.common.api;

import com.thunder.common.exception.CommonErrorInterface;
import lombok.Data;


/**
 * @description:
 * @author: liumiao
 * @create: 2020/9/8
 **/
@Data
public class JsonResult<T> {

    private String code;
    private String message;
    private T data;

    private JsonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private JsonResult() {

    }

    public static <T> JsonResult<T> success() {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> JsonResult<T> failed(CommonErrorInterface errorCode, String message) {
        return new JsonResult<T>(errorCode.getCode(), message, null);
    }

    public static <T> JsonResult<T> failed() {
        return new JsonResult<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null);
    }

    public static <T> JsonResult<T> failed(CommonErrorInterface iErrorCode) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setCode(iErrorCode.getCode());
        jsonResult.setMessage(iErrorCode.getMessage());
        return jsonResult;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }

}