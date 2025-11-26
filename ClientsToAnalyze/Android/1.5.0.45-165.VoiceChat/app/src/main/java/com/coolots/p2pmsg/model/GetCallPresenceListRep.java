package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GetCallPresenceListRep extends MsgBody {
    private List<CallPresenceInfo> CallPresenceInfoList = new ArrayList();

    public List<CallPresenceInfo> getCallPresenceInfoList() {
        return this.CallPresenceInfoList;
    }

    public void setCallPresenceInfoList(List<CallPresenceInfo> callPresenceInfoList) {
        this.CallPresenceInfoList = callPresenceInfoList;
    }
}
