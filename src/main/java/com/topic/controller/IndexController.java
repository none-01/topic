package com.topic.controller;

import com.topic.po.Topic;
import com.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private TopicService topicService;

    @RequestMapping({"/","userLogin"})
    public String userLogin(){
        return "userlogin";
    }

    @RequestMapping("userRegister")
    public String userRegister(){
        return "userRegister";
    }

    @RequestMapping("topicList")
    public String topicList(){
        return "topicList";
    }

    @RequestMapping("/topicContent/{topicInfoId}")
    public String topicContent(@PathVariable ("topicInfoId") Integer topicInfoId, Model model){
        Topic topic= topicService.querOneTopic(topicInfoId);
        model.addAttribute("topic",topic);
        return "topicContent";
    }

}
