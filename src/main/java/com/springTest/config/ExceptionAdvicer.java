package com.springTest.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvicer {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String, String> ExceptionHandler(Exception e) {
     Map<String, String> map = new HashMap<>();
     map.put("code","500");
     map.put("msg", "系统发生异常!!");
     return map;
    }
}
