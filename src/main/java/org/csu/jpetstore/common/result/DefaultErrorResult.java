package org.csu.jpetstore.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.csu.jpetstore.common.exception.BusinessException;
import org.csu.jpetstore.common.exception.ExceptionEnum;
import org.csu.jpetstore.uitls.RequestContextHolderUtil;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 默认全局错误返回格式
 *
 * @author: sun
 * @date: 2019/6/12
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DefaultErrorResult {
    public static final long serialVersionUID = 136400365941306385L;

    private Integer status;

    private String error;

    private String message;

    private Integer code;

    private String path;

    private String exception;

    private Object errors;

    private Date timestamp;

    /**
     * 设置更详细的错误信息
     *
     * @param errors
     * @return
     */
    public static DefaultErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus, Object errors) {
        DefaultErrorResult result = DefaultErrorResult.failure(resultCode, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    /**
     * 返回设置错误的结果
     *
     * @param resultCode
     * @param e
     * @param httpStatus
     * @return
     */
    public static DefaultErrorResult failure(ResultCode resultCode, Throwable e, HttpStatus httpStatus) {
        DefaultErrorResult result = new DefaultErrorResult();
        result.setCode(resultCode.code());
        result.setMessage(resultCode.message());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        result.setPath(RequestContextHolderUtil.getRequest().getRequestURI());
        result.setTimestamp(new Date());
        return result;
    }

    /**
     * 根据自定义业务异常类来返回错误结果
     *
     * @param e
     * @return
     */
    public static DefaultErrorResult failure(BusinessException e) {
        ExceptionEnum ee = ExceptionEnum.getByEClass(e.getClass());
        DefaultErrorResult defaultErrorResult = null;
        if (ee != null) {
//             DefaultErrorResult.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
            defaultErrorResult = DefaultErrorResult.failure(ee.getResultCode(), e, ee.getHttpStatus(), e.getData());
        } else {
            //        DefaultErrorResult defaultErrorResult = DefaultErrorResult.failure(e.getResultCode() == null ?
//                ResultCode.SUCCESS : e.getResultCode(), e, HttpStatus.OK, e.getData());
            defaultErrorResult = DefaultErrorResult.failure(e.getResultCode() == null ?
                    ResultCode.PARAM_IS_INVALID : e.getResultCode(), e, HttpStatus.OK, e.getData());
        }
        if (!StringUtils.isEmpty(e.getMessage())) {
            defaultErrorResult.setMessage(e.getMessage());
        }
        return defaultErrorResult;
    }

}
