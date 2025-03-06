package com.lzy12.service;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice   //为所有控制器（Controller）提供全局的数据绑定、数据预处理、异常处理等功能
//@RestControllerAdvice 这个就是ControllerAdvice加上responsebody注解
@RestControllerAdvice
public class ExceptionHandler {
    public Map<Object,Object> ExceptionHandler() {
        Map<Object,Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg","出现致命错误");
        return map;
    }
}
