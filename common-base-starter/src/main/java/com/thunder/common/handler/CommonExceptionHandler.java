package com.thunder.common.handler;

import com.thunder.common.api.JsonResult;
import com.thunder.common.exception.CommonErrorEnum;
import com.thunder.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: lim14905
 * @create: 2020/10/9
 **/
@RestControllerAdvice
public class CommonExceptionHandler {

    public CommonExceptionHandler() {
    }

    @ExceptionHandler({CommonException.class})
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handleCommonException(final CommonException ae) {
        return JsonResult.failed(ae.getErrorEnum());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handleDemoCheckException(MethodArgumentNotValidException ae) {
        return JsonResult.failed(CommonErrorEnum.G0000, ae.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public JsonResult handleRuntimeException(final Exception re) {
        return JsonResult.failed(CommonErrorEnum.G0000, re.getMessage());

    }

}
