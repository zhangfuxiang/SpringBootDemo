package com.example.springBootDemo.service;

import com.example.springBootDemo.entity.User;

/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 14:56
 * @Description:
 */
public interface UserService {
    int addUser(User user);

    User getUserById(int userId);
}
