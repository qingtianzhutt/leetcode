package com.example.entity;

public class UserInfo {
    private String userId;
    private String openUserId;
    private String openUserName;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenUserName() {
        return openUserName;
    }

    public void setOpenUserName(String openUserName) {
        this.openUserName = openUserName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }
}
