package com.example.demo.biz.service.impl.remote;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.biz.service.DemoService;
import com.example.demo.remote.param.DemoParam;
import com.example.demo.remote.result.DemoDTO;
import com.example.demo.remote.service.RpcDemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lvzhaoshuan
 * @date 2019/11/14
 */
//@Service
public class RpcDemoServiceImpl implements RpcDemoService {

    @Autowired
    private DemoService demoService;

    @Override
    public DemoDTO test(DemoParam param) {
        DemoDTO demo = new DemoDTO();
        //demo.setStr(demoService.test());
        return demo;
    }
}
