package com.example.springBootDemo.service.impl;

import com.example.springBootDemo.dao.UserMapper;
import com.example.springBootDemo.entity.User;
import com.example.springBootDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 14:57
 * @Description:
 */
@Service(value = "userService")
public class UseServiceImpl implements UserService {
    private final static Logger logger=LoggerFactory.getLogger(UseServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
