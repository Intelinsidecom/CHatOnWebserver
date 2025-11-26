package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class GetCallPresenceListAsk extends MsgBody {

    @Size(max = 10, min = 1)
    private List<MemberSimpleInfo> MemberSimpleInfoList = new ArrayList();

    public List<MemberSimpleInfo> getMemberSimpleInfoList() {
        return this.MemberSimpleInfoList;
    }

    public void setMemberSimpleInfoList(List<MemberSimpleInfo> memberSimpleInfoList) {
        this.MemberSimpleInfoList = memberSimpleInfoList;
    }
}
