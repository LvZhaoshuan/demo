package com.example.test;

import com.example.demo.web.DemoWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lvzhaoshuan
 * @date 2019/11/14
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoWebApplication.class})
public class LogbackTest {

    @Test
    public void testLog(){
        log.trace("=====trace=====");
        log.debug("=====debug=====");
        log.info("=====info=====");
        log.warn("=====warn=====");
        log.error("=====error=====");
    }
}
