package com.springTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @RequestMapping("/testLog")
    @ResponseBody
    String testLog() {
        logger.trace("---------这是一个级别{}的日志-----------","trace");
        logger.debug("---------这是一个级别{}的日志-----------","debug");
        logger.info("---------这是一个级别{}的日志-----------","info"); //spring Boot 默认是info级别
        logger.warn("---------这是一个级别{}的日志-----------","warn");
        logger.error("---------这是一个级别{}的日志-----------","error");
        return "success";
    }

    @RequestMapping("/thymeleafDemo")
    public String thymeleafDemo(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",18);
        model.addAllAttributes(map);
        return "thymeleafDemo";
    }
}
