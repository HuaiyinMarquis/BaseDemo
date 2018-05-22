package com.springTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {
        logger.trace("---------这是一个级别{}的日志-----------","trace");
        logger.debug("---------这是一个级别{}的日志-----------","debug");
        logger.info("---------这是一个级别{}的日志-----------","info"); //spring Boot 默认是info级别
        logger.warn("---------这是一个级别{}的日志-----------","warn");
        logger.error("---------这是一个级别{}的日志-----------","error");
        return "Hello World!";
    }
}
