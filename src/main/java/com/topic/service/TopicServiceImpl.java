package com.topic.service;

import com.topic.dao.TopicDao;
import com.topic.po.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> queryTopicInfo(int pageNum) {
        return topicDao.queryTopicInfo(pageNum);
    }

    @Override
    public void addTopicInfo(Topic topic) {
        topicDao.addTopicInfo(topic);
    }

    @Override
    public Topic querOneTopic(Integer topicInfoId) {
        return topicDao.querOneTopic(topicInfoId);
    }
}
