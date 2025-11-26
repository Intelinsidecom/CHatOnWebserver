package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeConferenceRep extends MsgBody {
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();
    private List<SimpleUserInfo> UnknownUserInfoList = new ArrayList();

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public List<SimpleUserInfo> getUnknownUserInfoList() {
        return this.UnknownUserInfoList;
    }

    public void setUnknownUserInfoList(List<SimpleUserInfo> unknownUserInfoList) {
        this.UnknownUserInfoList = unknownUserInfoList;
    }
}
