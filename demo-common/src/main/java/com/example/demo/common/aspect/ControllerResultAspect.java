package com.example.demo.common.aspect;

import com.example.demo.common.entity.Result;
import com.example.demo.common.error.SystemErrors;
import com.example.demo.common.exception.BizException;
import com.example.demo.common.util.ErrorUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author linjian
 * @date 2019/3/19
 */
@Slf4j
@Aspect
@Component
public class ControllerResultAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) && execution(com.example.demo.common.entity.Result *.*(..))")
    public void controllerResult() {
    }

    @Around("controllerResult()")
    public Result doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = new Result();
        try {
            result = (Result) proceedingJoinPoint.proceed();
        } catch (BizException e) {
            ErrorUtils.setThrowable(e);
            result.setSuccess(false);
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            ErrorUtils.setThrowable(e);
            result.setSuccess(false);
            result.setCode(SystemErrors.PARAM_ERROR.getCode());
            result.setMessage(e.getMessage());
        }catch (ConstraintViolationException e) {
            ErrorUtils.setThrowable(e);
            result.setSuccess(false);
            result.setCode(30003);
            result.setMessage(e.getMessage());
        } catch (RuntimeException e) {
            ErrorUtils.setThrowable(e);
            log.error("系统出错", e);
            result.setSuccess(false);
            result.setCode(SystemErrors.SYSTEM_ERROR.getCode());
            result.setMessage(SystemErrors.SYSTEM_ERROR.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        String regEx=":[\\S]+";
        String sql=" select * from a where id=:id and name=:sss ";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(sql);
        System.out.println(m.group());
    }
}
