package com.lzy12.service;

import com.lzy12.entity.UserEntity;
import com.lzy12.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional  //开启事务
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public UserEntity findUserByUsername(@Param("username") String username) {
        return userMapper.findUserByUsername(username);
    }
    public int insertUser(UserEntity user) {
        return userMapper.insertUser(user.getUsername(), user.getAge());
    }
}
