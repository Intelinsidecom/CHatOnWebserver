package com.coolots.chaton.call.model;

/* loaded from: classes.dex */
public class ConferenceCallDisplayUserInfo {
    public String userName = null;
    public int userCount = 0;

    public String toString() {
        return this.userName == null ? "userName : null, userCount: " + this.userCount : "userName : " + this.userName + ", userCount: " + this.userCount;
    }
}
