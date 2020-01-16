package com.example.demo.biz.service;

import com.example.demo.biz.service.impl.UserDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author lvzhaoshuan
 * @date 2019/11/13
 */
public interface DemoService {

    String test(@Valid UserDTO param);

    void print(@NotBlank String word);
}
