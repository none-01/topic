package com.topic.service;

import com.topic.dao.UserDao;
import com.topic.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void userReg(User user) {
        userDao.userReg(user);
    }

    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }
}
