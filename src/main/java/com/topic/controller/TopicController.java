package com.topic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topic.po.AjaxResult;
import com.topic.po.Topic;
import com.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/queryTopicInfo")
    public Object queryTopicInfo(@RequestParam(defaultValue = "1")
            int pageNum, @RequestParam(defaultValue = "2") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Topic> topics=topicService.queryTopicInfo(pageNum);
        PageInfo<Topic> pageInfo=new PageInfo<Topic>(topics,5);
        return pageInfo;
    }

    @PostMapping("/addTopicInfo")
    public  Object addTopicInfo(Topic topic, @RequestParam("file") MultipartFile file){
        AjaxResult ajaxResult=new AjaxResult();
        try {
            if (!file.isEmpty()){
                //创建fileDir对象,"C:/img/"这个内容可以是文件也可以是文件夹
                File fileDir = new File("C:/img/");
                //1.判断文件夹是否存在
                if(!fileDir.exists()){
                    //不存在的话,创建文件夹
                    fileDir.mkdirs();
                }
                String imgName= UUID.randomUUID() + ".jpg";
                try {
                    file.transferTo(new File("C:/img/" + imgName));
                    topic.setTopicImg("img/" + imgName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            topic.setCreateDate(new Date());
            topicService.addTopicInfo(topic);
            ajaxResult.setCode(0);
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setCode(1);
            ajaxResult.setMsg("添加失败！");
        }
        return ajaxResult;
    }
}
