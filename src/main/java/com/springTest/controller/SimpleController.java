package com.springTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, String> map, HttpSession session) {
        if (! "admin".equals(password)) {
            map.put("msg", "账号或者密码输入不正确，请重新输入");
            return "/login";
        }
        String b2c = (String) session.getAttribute("b2c");
        session.setAttribute("loginUser",username);
        return "redirect:/home";
    }

}
