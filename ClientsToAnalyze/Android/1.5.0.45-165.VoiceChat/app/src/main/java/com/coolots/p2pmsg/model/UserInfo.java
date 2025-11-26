package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class UserInfo {
    private String ChatName;
    private String ImageInfoChange;
    private String IsChatInput;
    private String IsFSUsable;
    private String IsSvrAskNewInfo;
    private String SystemInfo;
    private long UserNo;
    private String UserStatus;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getUserStatus() {
        return this.UserStatus;
    }

    public void setUserStatus(String userStatus) {
        this.UserStatus = userStatus;
    }

    public String getImageInfoChange() {
        return this.ImageInfoChange;
    }

    public void setImageInfoChange(String imageInfoChange) {
        this.ImageInfoChange = imageInfoChange;
    }

    public String getChatName() {
        return this.ChatName;
    }

    public void setChatName(String chatName) {
        this.ChatName = chatName;
    }

    public String getIsChatInput() {
        return this.IsChatInput;
    }

    public void setIsChatInput(String isChatInput) {
        this.IsChatInput = isChatInput;
    }

    public String getIsFSUsable() {
        return this.IsFSUsable;
    }

    public void setIsFSUsable(String isFSUsable) {
        this.IsFSUsable = isFSUsable;
    }

    public String getIsSvrAskNewInfo() {
        return this.IsSvrAskNewInfo;
    }

    public void setIsSvrAskNewInfo(String isSvrAskNewInfo) {
        this.IsSvrAskNewInfo = isSvrAskNewInfo;
    }

    public String getSystemInfo() {
        return this.SystemInfo;
    }

    public void setSystemInfo(String systemInfo) {
        this.SystemInfo = systemInfo;
    }
}
