package com.lzy12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步方法需要放置在调用该异步方法的文件外
 * 换言之
 * 就是调用异步方法与异步方法不能是同一个文件
 * 否则无法正确被执行
 */
@Slf4j
@Component
public class AsyncService {
    @Async("taskExecutor")
    public void smsAsync() {    //异步方法需要返回void类型
        log.info(">02<");
        try {
            log.info(">正在发送短信..<");
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        log.info(">03<");
//        return "短信发送完成!";
    }
}
