package com.topic.dao;

import com.topic.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    //添加用户
    void userReg(User user);

    //用户登录
    User userLogin(User user);
}
