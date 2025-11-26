package com.coolots.chaton.buddy.model;

/* loaded from: classes.dex */
public class BuddyListGroupItem {
    private String mGroupMame;
    private int mGroupMember;

    public BuddyListGroupItem(String userID, String name, String photourl, int member) {
        this.mGroupMame = name;
        this.mGroupMember = member;
    }

    public String getName() {
        return this.mGroupMame;
    }

    public int getMembers() {
        return this.mGroupMember;
    }

    public void setName(String name) {
        this.mGroupMame = name;
    }

    public void setMsg(int member) {
        this.mGroupMember = member;
    }
}
