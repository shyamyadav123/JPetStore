package org.csu.jpetstore.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.csu.jpetstore.common.result.DefaultErrorResult;
import org.csu.jpetstore.common.result.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.net.BindException;

/**
 * 全局异常处理基础类
 * @author: sun
 * @date: 2019/6/12
 */
@Slf4j
public class BaseGlobalExceptionHandler {

    /**
     * 违反约束异常
     *
     * @param e 参数验证约束异常
     */
    protected DefaultErrorResult handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        log.info("handleConstraintViolationException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理验证参数封装错误时异常
     * @param e
     * @return
     */
    protected DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.info("handleConstraintViolationException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 参数绑定异常 （反400错误码）
     */
    protected DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        log.info("handleBindException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理使用@Validated注解时，参数验证错误异常（反400错误码）
     */
    protected DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.info("handleMethodArgumentNotValidException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.PARAM_IS_INVALID, e, HttpStatus.BAD_REQUEST);
    }

    /**
     * 处理通用自定义业务逻辑异常
     */

    /**
     * 处理运行时系统异常 500
     */
    protected DefaultErrorResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        log.info("handleRuntimeException start, uri:{}, caused by: ", request.getRequestURI(), e);
        return DefaultErrorResult.failure(ResultCode.SYSTEM_INNER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
