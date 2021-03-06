package com.example.demo.common.aspect;


import com.example.demo.common.entity.Result;
import com.example.demo.common.error.SystemErrors;
import com.example.demo.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author linjian
 * @date 2019/3/19
 */
@Slf4j
@Aspect
@Component
public class RemoteServiceAspect {

    @Pointcut("execution(* com.example.*.remote.service.*.*(..))")
    public void remoteService() {
    }

    @Around("remoteService()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Exception e) {
            return exceptionProcessor(proceedingJoinPoint, e);
        }
    }

    private Object exceptionProcessor(ProceedingJoinPoint proceedingJoinPoint, Exception e) {
        Object[] args = proceedingJoinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getMethod().getDeclaringClass().getName();
        String methodName = methodSignature.getMethod().getName();
        Class returnType = methodSignature.getReturnType();
        log.error("dubbo服务[method=" + className + "." + methodName + "] params=" + Arrays.toString(args) + "异常：", e);
        if (returnType.equals(Result.class)) {
            Result result = new Result();
            result.setSuccess(false);
            if (e instanceof BizException) {
                result.setCode(((BizException) e).getCode());
                result.setMessage(e.getMessage());
            } else if (e instanceof IllegalArgumentException) {
                result.setCode(SystemErrors.PARAM_ERROR.getCode());
                result.setMessage(e.getMessage());
            } else {
                result.setCode(SystemErrors.SYSTEM_ERROR.getCode());
                result.setMessage(SystemErrors.SYSTEM_ERROR.getMessage());
            }
            return result;
        }
        return null;
    }
}
