package com.lzy12.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.lzy12.controller..*(..)) || execution(* com.lzy12.service..*(..))")
    public void pointCut() {
    //定义一个切面，让所有访问这个项目的所有请求都会先访问这个切面
        //然后再将前置后置环绕的value填写这个方法
    }
    @Before("pointCut()")
    public void before() {
        log.info("before");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        /**
         * 这里要使用trycatch
         * 因为如果是异步方法的执行，将无法获得访问者IP等信息
         * 然后进程就会报错
         * 然后异步方法将会因为报错而被终止无法执行
         */
        try{
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("request url:{}", request.getRequestURL());
        log.info("request method:{}", request.getMethod());
        log.info("request ip:{}", request.getRemoteAddr());
    }
        catch(Exception e){
        log.info("it is async");
        }
    }
    @After("pointCut()")
    public void after() {
        log.info("after");
    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around");
        Object result = joinPoint.proceed();
        log.info("around result:{}", result);
        return result;
    }
}
