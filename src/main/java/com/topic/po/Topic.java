package com.topic.po;

import java.util.Date;

public class Topic {
    private Integer topicInfoId;
    private String topicImg;
    private String topicTitle;
    private String topicBrief;
    private String topicContent;
    private Date createDate;
    private Date updaterDate;

    public Topic() {
    }

    public Topic(Integer topicInfoId, String topicImg, String topicTitle, String topicBrief, String topicContent, Date createDate, Date updaterDate) {
        this.topicInfoId = topicInfoId;
        this.topicImg = topicImg;
        this.topicTitle = topicTitle;
        this.topicBrief = topicBrief;
        this.topicContent = topicContent;
        this.createDate = createDate;
        this.updaterDate = updaterDate;
    }

    public Integer getTopicInfoId() {
        return topicInfoId;
    }

    public void setTopicInfoId(Integer topicInfoId) {
        this.topicInfoId = topicInfoId;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicBrief() {
        return topicBrief;
    }

    public void setTopicBrief(String topicBrief) {
        this.topicBrief = topicBrief;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdaterDate() {
        return updaterDate;
    }

    public void setUpdaterDate(Date updaterDate) {
        this.updaterDate = updaterDate;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicInfoId=" + topicInfoId +
                ", topicImg='" + topicImg + '\'' +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicBrief='" + topicBrief + '\'' +
                ", topicContent='" + topicContent + '\'' +
                ", createDate=" + createDate +
                ", updaterDate=" + updaterDate +
                '}';
    }
}
