package com.example.demo.biz.service.impl;

import com.example.demo.biz.service.DemoService;
import com.example.demo.common.redis.RedisClient;
import com.example.demo.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author lvzhaoshuan
 * @date 2019/11/13
 */
@Service
@Validated
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisClient redisClient;

    @Override
    public String test(UserDTO param) {
        //UserDO user = userMapper.selectById(1);
        //redisClient.set("user:1", user, CacheTime.CACHE_EXP_FIVE_MINUTES);
        return param.toString();
    }

    @Override
    public void print(@NotBlank String word) {
        System.out.println(word);
    }
}
