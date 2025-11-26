package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionConferenceInfoRep extends MsgBody {
    private String ConferenceType;
    private String PresenterUserID;
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public String getConferenceType() {
        return this.ConferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.ConferenceType = conferenceType;
    }

    public String getPresenterUserID() {
        return this.PresenterUserID;
    }

    public void setPresenterUserID(String presenterUserID) {
        this.PresenterUserID = presenterUserID;
    }
}
