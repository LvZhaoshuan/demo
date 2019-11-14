package com.example.demo.remote.service;

import com.example.demo.remote.param.DemoParam;
import com.example.demo.remote.result.DemoDTO;

/**
 * @author lvzhaoshuan
 * @date 2019/11/14
 */
public interface RpcDemoService {

    /**
     * Dubbo 接口测试
     *
     * @param param DemoParam
     * @return DemoDTO
     */
    DemoDTO test(DemoParam param);
}
