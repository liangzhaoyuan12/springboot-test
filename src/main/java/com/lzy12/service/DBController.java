package com.lzy12.service;

import com.lzy12.entity.UserEntity;
import com.lzy12.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j //开启Lombok的日志支持
public class DBController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/getUser/{username}")
    public UserEntity getUserByName(@PathVariable("username") String username) {
        log.info("getUserByName username:{}", username);
        return userMapper.findUserByUsername(username);
    }
    @PostMapping("/insert")
    public String insertUser(@RequestBody UserEntity user) {   //表示通过json接收数据
        if(userMapper.insertUser(user.getUsername(), user.getAge())>0)
            return "insert success";
        else return "insert fail";
    }

}
