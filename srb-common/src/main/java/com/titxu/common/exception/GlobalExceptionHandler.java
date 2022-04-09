package com.titxu.common.exception;

import com.titxu.common.result.R;
import com.titxu.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice(basePackages = {"com.titxu.storage.controller", "com.titxu.sms.controller", "com.titxu.core.result"})
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R<Object> handleException(Exception e){
        log.error(e.getMessage(), e);
        return R.error();
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public R<Object> handleException(BadSqlGrammarException e){
        log.error(e.getMessage(), e);
        return R.setResponseEnum(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }


    @ExceptionHandler(value = BusinessException.class)
    public R<Object> handleException(BusinessException e){
        log.error(e.getMessage(), e);
        return R.error().msg(e.getMessage()).code(e.getCode());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R MethodArgumentNotValidHandler(
            MethodArgumentNotValidException exception) {
        //按需重新封装需要返回的错误信息
        List<ArgumentInvalidResponse> invalidArguments = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ArgumentInvalidResponse invalidArgument = new ArgumentInvalidResponse();
            invalidArgument.setErrorMessage(error.getDefaultMessage());
            invalidArgument.setField(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArguments.add(invalidArgument);
        }
        return R.setResponseEnum(ResponseEnum.PARAM_ERROR).data(invalidArguments);
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R<Object> handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return R.error().msg(ResponseEnum.SERVLET_ERROR.getMsg()).code(ResponseEnum.SERVLET_ERROR.getCode());
    }
}
