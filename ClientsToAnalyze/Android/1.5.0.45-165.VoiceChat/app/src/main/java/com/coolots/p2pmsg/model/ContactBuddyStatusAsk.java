package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ContactBuddyStatusAsk extends MsgBody {
    private String BuddyUserID;

    public String getBuddyUserID() {
        return this.BuddyUserID;
    }

    public void setBuddyUserID(String buddyUserID) {
        this.BuddyUserID = buddyUserID;
    }
}
