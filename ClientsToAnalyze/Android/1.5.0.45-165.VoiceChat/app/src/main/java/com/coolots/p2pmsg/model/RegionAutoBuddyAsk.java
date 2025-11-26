package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAutoBuddyAsk extends MsgBody {
    private List<PhoneBookInfo> PhoneBookInfoList = new ArrayList();
    private ProfileInfo ProfileInfo;
    private String SamsungAccountID;

    public ProfileInfo getProfileInfo() {
        return this.ProfileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.ProfileInfo = profileInfo;
    }

    public List<PhoneBookInfo> getPhoneBookInfoList() {
        return this.PhoneBookInfoList;
    }

    public void setPhoneBookInfoList(List<PhoneBookInfo> phoneBookInfoList) {
        this.PhoneBookInfoList = phoneBookInfoList;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }
}
