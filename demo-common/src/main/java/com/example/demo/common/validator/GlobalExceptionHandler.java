package com.example.demo.common.validator;

import com.example.demo.common.entity.Result;
import com.example.demo.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Objects;

/**
 * @author lvzhaoshuan
 * @date 2020/1/16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    private static final int DUPLICATE_KEY_CODE = 1001;

    private static final int PARAM_FAIL_CODE = 1002;

    private static final int VALIDATION_CODE = 1003;

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BizException.class)
    public Result<Boolean> handleRRException(BizException e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(e.getCode(), e.getMessage());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Boolean> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(PARAM_FAIL_CODE, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public Result<Boolean> handleValidationException(ValidationException e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(VALIDATION_CODE, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Boolean> handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(PARAM_FAIL_CODE, e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<Boolean> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public Result<Boolean> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.wrapErrorResult(500, "系统繁忙,请稍后再试");
    }
}
