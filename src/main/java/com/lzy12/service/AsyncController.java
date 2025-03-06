package com.lzy12.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("/async")
    public String async() {
        log.info("1");
        asyncService.smsAsync();
        log.info("4");
        return "end";
    }

}
