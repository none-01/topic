package com.topic.dao;

import com.topic.po.Topic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicDao {
    //查询话题列表
    List<Topic> queryTopicInfo(int pageNum);

    //添加话题
    void addTopicInfo(Topic topic);

    //查询内容
    Topic querOneTopic(@Param("topicInfoId") Integer topicInfoId);
}
