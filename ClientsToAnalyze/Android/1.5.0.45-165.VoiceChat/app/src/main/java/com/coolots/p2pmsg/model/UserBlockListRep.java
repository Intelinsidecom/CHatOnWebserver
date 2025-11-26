package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class UserBlockListRep extends MsgBody {
    private List<UserBlockInfo> UserBlockInfoList = new ArrayList();

    public List<UserBlockInfo> getUserBlockInfoList() {
        return this.UserBlockInfoList;
    }

    public void setUserBlockInfoList(List<UserBlockInfo> userBlockInfoList) {
        this.UserBlockInfoList = userBlockInfoList;
    }
}
