package com.example.demo.web.controller;

import com.example.demo.biz.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvzhaoshuan
 * @date 2019/11/13
 */
@Api(tags = "demo")
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation("测试")
    @GetMapping("test")
    public String test() {
        return demoService.test();
    }
}