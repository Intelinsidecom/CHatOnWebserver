package com.coolots.chaton.call.model;

/* loaded from: classes.dex */
public class CallDisplayUserInfo {
    public String userName = "";
    public String userStateMsg = "";
    public long userNo = 0;
    public String userID = "";

    public String toString() {
        String message = (this.userID != null ? "[CallDisplayUserInfo] ".concat(" userID: " + this.userID) : "[CallDisplayUserInfo] ").concat(" userNo: " + this.userNo);
        if (this.userName != null) {
            message = message.concat(" userName: " + this.userName);
        }
        return this.userStateMsg != null ? message.concat(" userStateMsg: " + this.userStateMsg) : message;
    }
}
