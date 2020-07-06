package com.topic.service;

import com.topic.po.Topic;

import java.util.List;

public interface TopicService {

    //查询话题列表
    List<Topic> queryTopicInfo(int pageNum);

    //添加话题
    void addTopicInfo(Topic topic);

    //查询内容
    Topic querOneTopic(Integer topicInfoId);
}
