package com.example.demo.web.controller;

import com.example.demo.biz.service.DemoService;
import com.example.demo.biz.service.impl.UserDTO;
import com.example.demo.common.validator.groups.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("test")
    public String test(@RequestBody @Validated(Update.class) UserDTO param) {
        return demoService.test(param);
    }

    @ApiOperation("测试")
    @GetMapping("sout")
    public void test() {
        demoService.print("");
    }
}