package com.example.demo.common.entity;


import com.example.demo.common.error.ServiceErrors;

import java.io.Serializable;

/**
 * @author linjian
 * @date 2018/9/26
 */
public class Result<D> implements Serializable {

    private D data;

    private boolean success;

    private Integer code;

    private String message;

    public Result() {
    }

    public static <D> Result<D> wrapSuccessfulResult(D data) {
        Result<D> result = new Result<D>();
        result.data = data;
        result.success = true;
        result.code = 0;
        return result;
    }

    public static <T> Result<T> wrapSuccessfulResult(String message, T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.success = true;
        result.code = 0;
        result.message = message;
        return result;
    }

    public static <D> Result<D> wrapErrorResult(ServiceErrors error) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = error.getCode();
        result.message = error.getMessage();
        return result;
    }

    public static <D> Result<D> wrapErrorResult(ServiceErrors error, Object... extendMsg) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = error.getCode();
        result.message = String.format(error.getMessage(), extendMsg);
        return result;
    }

    public static <D> Result<D> wrapErrorResult(Integer code, String message) {
        Result<D> result = new Result<D>();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }

    public D getData() {
        return this.data;
    }

    public Result<D> setData(D data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Result<D> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public Result<D> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Result<D> setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("success=");
        sb.append(this.success);
        sb.append(",");
        sb.append("code=");
        sb.append(this.code);
        sb.append(",");
        sb.append("message=");
        sb.append(this.message);
        sb.append(",");
        sb.append("data=");
        sb.append(this.data);
        sb.append("}");
        return sb.toString();
    }
}
