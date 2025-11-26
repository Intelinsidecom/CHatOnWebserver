package com.sds.coolots.call.model;

/* loaded from: classes.dex */
public class ConferenceMember {
    public String inviteUserID;
    public String userID;
    public String userName;
    public String userPhone;

    public ConferenceMember() {
        this.userID = null;
        this.userName = null;
        this.userPhone = null;
    }

    public ConferenceMember(String str, String str2) {
        this.userID = str;
        this.userName = str2;
        this.userPhone = null;
    }

    public ConferenceMember(String str, String str2, String str3) {
        this.userID = str;
        this.userName = str2;
        this.userPhone = str3;
    }

    public ConferenceMember(String str, String str2, String str3, String str4) {
        this.userID = str;
        this.userName = str2;
        this.userPhone = str3;
        this.inviteUserID = str4;
    }
}
