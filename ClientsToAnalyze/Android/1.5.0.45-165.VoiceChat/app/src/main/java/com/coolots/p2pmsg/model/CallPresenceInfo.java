package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class CallPresenceInfo {
    public static final String PRESENCE_NO = "N";
    public static final String PRESENCE_YES = "Y";

    @NotNull
    private MemberSimpleInfo MemberSimpleInfo;

    @NotNull
    private String Presence;

    public MemberSimpleInfo getMemberSimpleInfo() {
        return this.MemberSimpleInfo;
    }

    public void setMemberSimpleInfo(MemberSimpleInfo memberSimpleInfo) {
        this.MemberSimpleInfo = memberSimpleInfo;
    }

    public String getPresence() {
        return this.Presence;
    }

    public void setPresence(String presence) {
        this.Presence = presence;
    }
}
