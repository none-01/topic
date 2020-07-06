package com.topic.service;

import com.topic.po.User;

public interface UserService {
    //添加用户
    void userReg(User user);

    //用户登录
    User userLogin(User user);
}
