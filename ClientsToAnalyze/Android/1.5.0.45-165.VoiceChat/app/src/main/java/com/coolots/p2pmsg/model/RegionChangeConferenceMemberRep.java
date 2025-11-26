package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionChangeConferenceMemberRep extends MsgBody {
    private List<SimpleUserInfo> NewUserInfoList = new ArrayList();

    public List<SimpleUserInfo> getNewUserInfoList() {
        return this.NewUserInfoList;
    }

    public void setNewUserInfoList(List<SimpleUserInfo> newUserInfoList) {
        this.NewUserInfoList = newUserInfoList;
    }
}
