package com.topic.po;

import java.util.Date;

public class User {
    private Integer userId;
    private String phoneNumber;
    private String password;
    private String  invite;
    private Date createDate;
    private Date updaterDate;

    public User() {
    }

    public User(Integer userId, String phoneNumber, String password, String invite, Date createDate, Date updaterDate) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.invite = invite;
        this.createDate = createDate;
        this.updaterDate = updaterDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
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
        return "User{" +
                "userId=" + userId +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", invite='" + invite + '\'' +
                ", createDate=" + createDate +
                ", updaterDate=" + updaterDate +
                '}';
    }
}
