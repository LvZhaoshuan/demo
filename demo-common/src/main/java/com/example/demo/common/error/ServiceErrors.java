package com.example.demo.common.error;

import java.io.Serializable;

/**
 * @author linjian
 * @date 2018/9/26
 */
public interface ServiceErrors extends Serializable {

    /**
     * 获取错误码
     *
     * @return Integer
     */
    Integer getCode();

    /**
     * 获取错误信息
     *
     * @return String
     */
    String getMessage();
}
