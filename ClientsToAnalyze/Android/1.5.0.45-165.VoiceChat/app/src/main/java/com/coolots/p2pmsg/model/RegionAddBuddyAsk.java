package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddBuddyAsk extends MsgBody {
    private List<BuddyInfo> BuddyList = new ArrayList();
    private ProfileInfo ProfileInfo;
    private String SamsungAccountID;

    public ProfileInfo getProfileInfo() {
        return this.ProfileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.ProfileInfo = profileInfo;
    }

    public List<BuddyInfo> getBuddyList() {
        return this.BuddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.BuddyList = buddyList;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }
}
