package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    /**
     * 处理自定义异常
     *
     */
    @ExceptionHandler(value = BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.defineError(e);
    }

    /**
     *处理其他异常
     *
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler( Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }

}
