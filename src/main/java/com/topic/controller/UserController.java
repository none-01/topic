package com.topic.controller;

import com.topic.po.AjaxResult;
import com.topic.po.User;
import com.topic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/userReg")
    public Object userReg(User user){
        AjaxResult ajaxResult=new AjaxResult();
        try {
            user.setCreateDate(new Date());
            userService.userReg(user);
            ajaxResult.setCode(0);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setMsg("注册失败!");
        }
        return ajaxResult;
    }

    @PostMapping("/userLogin")
    public Object userLogin(User user){
        AjaxResult ajaxResult=new AjaxResult();
        try {
            User userInfo=userService.userLogin(user);
            System.out.println(userInfo);
            if(userInfo!=null){
                ajaxResult.setCode(0);
            }else{
                ajaxResult.setCode(1);
                ajaxResult.setMsg("登录密码错误!");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setMsg("登录失败!");
        }
        return ajaxResult;
    }

}
