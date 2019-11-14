package com.example.demo.web;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author lvzhaoshuan
 * @date 2019/11/13
 */
@MapperScan("com.example.demo.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.example.demo")
@DubboComponentScan(basePackages = "com.example.demo.biz.service.impl.remote")
public class DemoWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoWebApplication.class);
    }
}
